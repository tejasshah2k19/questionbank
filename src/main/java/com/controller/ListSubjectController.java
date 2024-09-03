
package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SubjectBean;
import com.dao.SubjectDao;


@WebServlet("/ListSubjectController")
public class ListSubjectController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SubjectDao dao = new SubjectDao();
		ArrayList<SubjectBean> subjects = dao.getAllSubjects();
		
		request.setAttribute("subjects", subjects);
		RequestDispatcher rd = request.getRequestDispatcher("ListSubject.jsp");
		rd.forward(request, response);
	}
}