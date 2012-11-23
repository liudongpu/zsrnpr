package com.srnpr.com.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextLoaderListener extends ContextLoader implements ServletContextListener {

	
	private ContextLoader contextLoader;
	
	public void contextDestroyed(ServletContextEvent event) {
		
		
	}

	public void contextInitialized(ServletContextEvent event) {
		
		
		if (this.contextLoader == null) {
			this.contextLoader = this;
		}
		this.contextLoader.Init(event.getServletContext());
		
	}

}
