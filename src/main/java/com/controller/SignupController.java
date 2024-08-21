package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
import com.util.ValidationUtil;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String contactNum = request.getParameter("contactNum");
		String city = request.getParameter("city");

		boolean isError = false;

		if (ValidationUtil.isEmpty(firstName)) {
			isError = true;
			request.setAttribute("firstNameError", "Please Enter FirstName");
		} else if (ValidationUtil.isAlpha(firstName) == false) {
			isError = true;
			request.setAttribute("firstNameError", "Please Enter Valid FirstName");
		}

		if (ValidationUtil.isEmpty(lastName)) {
			isError = true;
			request.setAttribute("lastNameError", "Please Enter LastName");
		} else if (ValidationUtil.isAlpha(lastName) == false) {
			isError = true;
			request.setAttribute("lastNameError", "Please Enter Valid LastName");
		}

		if (ValidationUtil.isEmpty(email)) {
			isError = true;
			request.setAttribute("emailError", "Please Enter Email");
		} else if (ValidationUtil.isEmail(email) == false) {
			isError = true;
			request.setAttribute("emailError", "Please Enter Valid Email");
		}

		if (ValidationUtil.isEmpty(password)) {
			isError = true;
			request.setAttribute("passwordError", "Please Enter Password");
		} else if (ValidationUtil.checkLength(password, 8) == false) {
			isError = true;
			request.setAttribute("passwordError", "Please Enter atleast 8 character in Password");
		}

		if (ValidationUtil.isEmpty(gender)) {
			isError = true;
			request.setAttribute("genderError", "Please Selecte Gender");
		}

		if (ValidationUtil.isEmpty(city)) {
			isError = true;
			request.setAttribute("cityError", "Please Selecte City");
		}
		if (ValidationUtil.isEmpty(contactNum)) {
			isError = true;
			request.setAttribute("contactNumError", "Please Enter Contact Num");
		}

		UserBean user = new UserBean();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setEmail(email);
		user.setPassword(password);
		user.setCity(city);
		user.setContactNum(contactNum);
		user.setRole("STUDENT");

		if (isError == true) {

			request.setAttribute("user", user);
			request.getRequestDispatcher("Signup.jsp").forward(request, response);
		} else {
			// database insert
			UserDao userDao = new UserDao();
			userDao.addUser(user);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}

	}
}
