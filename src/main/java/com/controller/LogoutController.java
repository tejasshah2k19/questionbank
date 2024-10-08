package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie e = new Cookie("email","");
		e.setMaxAge(0);
		response.addCookie(e);
		
		Cookie n = new Cookie("firstName","");
		n.setMaxAge(0);
		response.addCookie(n);
		
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("Login.jsp");
	}

}
