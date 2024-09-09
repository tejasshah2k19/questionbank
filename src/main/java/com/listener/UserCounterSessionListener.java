package com.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class UserCounterSessionListener implements HttpSessionListener {

	static int count = 0;

	public void sessionCreated(HttpSessionEvent event) {
		// session create
		count++;
		System.out.println("In :: " + count);
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		// session destroy
		count--;
		System.out.println("Out :: " + count);
		HttpSession session = event.getSession();
		System.out.println(session.getAttribute("firstName")+" Logout...");

	}

}
