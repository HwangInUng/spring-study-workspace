package com.edu.springdb.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String dataPath = context.getInitParameter("dataPath");
		dataPath = context.getRealPath(dataPath);
		context.setAttribute("dataPath", dataPath);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
