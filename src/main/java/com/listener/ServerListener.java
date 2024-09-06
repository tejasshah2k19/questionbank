package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServerListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// stop

		System.out.println("SERVER STOP ==> ");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// start
		// nse connection open
		System.out.println("SERVER STARTED ==> ");
	}

}
