package com.edu.springmvc2.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *프론트 컨트롤러의 채널이 다른 경우에는
 *서버의 생명주기와 동일한 객체에 공통된 Model객체를 보관하여
 *공유할 수 있다.
 *
 *그러한 역할을 하는 것이 리스너 객체이며, 서버 시작시점에 객체들을 보유하고,
 *종료 시점에 자원의 낭비를 방지하기 위해 삭제
 * */
public class ContextLoaderListener implements ServletContextListener{
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	//jsp의 application 객체 getRealPath() 등을 이용
	ServletContext servletContext;
	ApplicationContext applicationContext;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		servletContext = sce.getServletContext();
		applicationContext = new ClassPathXmlApplicationContext(servletContext.getInitParameter("contextConfigLocation"));
		
		log.info("서버 시작");
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.info("서버 중지");
		
	}
}
