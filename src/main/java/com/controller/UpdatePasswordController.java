package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/UpdatePasswordController")
public class UpdatePasswordController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String otp = request.getParameter("otp");

		UserBean user = new UserBean();
		user.setEmail(email);
		user.setPassword(pass);
		user.setOtp(otp);
		
		//select * from users where email = ? and otp = ? 
		
		UserDao userDao = new UserDao();

		boolean ans = userDao.checkOTP(user);
		
		if(ans == true) {
			userDao.updatePassword(user);
			request.setAttribute("msg", "Password modified");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("error", "Invalid Data");
			RequestDispatcher rd = request.getRequestDispatcher("UpdatePassword.jsp");
			rd.forward(request, response);
			
		}
		
	}
}
