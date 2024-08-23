package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/ForgotPasswordController")
public class ForgotPasswordController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		System.out.println("email =>"+email);
		UserDao userDao = new UserDao();

		UserBean user = userDao.getUserByEmail(email);

		if (user == null) {
			// invalid email
			request.setAttribute("error", "Invalid Email");
			request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);

		} else {
			// user found with email
			// now generate otp
 
			StringBuffer sb = new StringBuffer();

			for (int i = 1; i <= 6; i++) {
				int x = (int) (Math.random() * 9);
				sb.append(x);//264059
			}
			String otp  = sb.toString();//string buffer string 
			// send mail
			System.out.println("OTP =>"+otp);
			request.getRequestDispatcher("UpdatePassword.jsp").forward(request, response);
			
		}
	}

}
