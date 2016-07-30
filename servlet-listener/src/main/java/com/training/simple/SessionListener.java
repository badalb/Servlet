package com.training.simple;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@javax.servlet.annotation.WebListener
public class SessionListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context destroyed!");

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Context created!");
	}

}