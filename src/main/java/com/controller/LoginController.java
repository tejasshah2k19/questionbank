package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDao userDao = new UserDao();

		UserBean user = userDao.authenticate(email, password);

		if (user == null) {
			request.setAttribute("error", "Invalid Credentials");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {

			Cookie c = new Cookie("email", email); // create cookie
			c.setMaxAge(60 * 60 * 24);
			response.addCookie(c); // set this cookie to the browser

			Cookie fn = new Cookie("firstName", user.getFirstName());
			fn.setMaxAge(60 * 60 * 24);
			response.addCookie(fn);
			
			if (user.getRole().equals("STUDENT")) {
				request.getRequestDispatcher("StudentHome.jsp").forward(request, response);

			} else if (user.getRole().equals("ADMIN")) {
				request.getRequestDispatcher("AdminHome.jsp").forward(request, response);

			}
		}
	}

}
