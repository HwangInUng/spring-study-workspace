package com.edu.springshop.aop;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.model.category.CategoryService;

/*메뉴 이동 간 부가적으로 필요한 카테고리 리스트 출력을 위한 코드*/
public class CategoryAdvice {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CategoryService categoryService;

	public Object getCategoryList(ProceedingJoinPoint joinPoint) throws Throwable {
		// joinPoint : 메서드 호출 전/후로 관여할 수 있도록 지원

		// 반환값으로 사용할 변수
		Object result = null;

		Object[] args = joinPoint.getArgs();
		HttpServletRequest request = null;
		for(Object arg : args) {
			if(arg instanceof HttpServletRequest) {
				request = (HttpServletRequest) arg;
			}
		}
		
		String uri = request.getRequestURI();
		
		if (uri.equals("/rest/member")) {
			result = joinPoint.proceed();
		} else {
			// 공통 메소드 수행
			List categoryList = categoryService.selectAll();

			ModelAndView mav = null;

			result = joinPoint.proceed(); // controller 메소드 호출시점

			if (result instanceof ModelAndView) {
				mav = (ModelAndView) result; // controller 메소드의 반환값 다운캐스팅
				mav.addObject("categoryList", categoryList);
				result = mav;
			}
		}
		return result;
	}
}
