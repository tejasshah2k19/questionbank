package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SetTimeoutController")
public class SetTimeoutController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer time = Integer.parseInt(request.getParameter("time"));
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60 * time);
		response.sendRedirect("AdminHome.jsp");
	}

}
