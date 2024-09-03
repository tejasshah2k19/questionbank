package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SubjectBean;
import com.dao.SubjectDao;
import com.util.ValidationUtil;

@WebServlet("/AddSubjectController")
public class AddSubjectController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newSubject = request.getParameter("subjectName");
		boolean isError = false;
		if (ValidationUtil.isEmpty(newSubject)) {
			isError = true;
			request.setAttribute("SubError", "Please Enter Subject");
		} else if (ValidationUtil.isAlpha(newSubject) == false) {
			isError = true;
			request.setAttribute("SubError", "Please Enter Valid Subject Name");
		}

		if (isError == true) {
			SubjectBean sub = new SubjectBean();
			sub.setSubjectName(newSubject);

			request.setAttribute("sub", sub);
			request.getRequestDispatcher("NewSubject.jsp").forward(request, response);

		} else {
			SubjectBean sub = new SubjectBean();
			sub.setSubjectName(newSubject);
			;
			SubjectDao dao = new SubjectDao();
			dao.InsertSub(sub);
			request.getRequestDispatcher("AdminHome.jsp").forward(request, response);

		}
	}
}