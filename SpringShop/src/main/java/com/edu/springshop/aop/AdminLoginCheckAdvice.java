package com.edu.springshop.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.edu.springshop.exception.AdminException;

public class AdminLoginCheckAdvice {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	public Object sessionCheck(ProceedingJoinPoint joinPoint) throws AdminException, Throwable{
		log.debug("====== 로그인 여부 판단 ======");
		Object result = null; //proceed로 얻는 메소드의 반환값
		
		Object[] args = joinPoint.getArgs();

		HttpServletRequest request = null;
		HttpSession session = null;

		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof HttpServletRequest) {
				request = (HttpServletRequest) args[i];
				session = request.getSession();
			}
		}
		
		//넘겨받은 URI로 조건 판단
		String uri = request.getRequestURI();
		if(uri.equals("/admin/loginform") || uri.equals("/admin/rest/login-admin")) {
			log.debug("====== 로그인 페이지 접속 ======");
			result = joinPoint.proceed(); //로그인 화면에 대한 내용은 판단 미실시
		} else {
			//로그인이 필요한 서비스에서만 해당 코드 수행
			if (session.getAttribute("admin") == null) {
				log.debug("AOP 확인결과 로그인정보 없음");
				throw new AdminException("로그인이 필요한 서비스입니다.");
			} else {
				result = joinPoint.proceed(); //로그인이 완료된 사람은 해당 메뉴로 이동
			}
		}
		
		log.debug("====== 페이지 출력 ======");
		return result;
	}
	
}
