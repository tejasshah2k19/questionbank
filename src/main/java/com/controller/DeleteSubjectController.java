package com.controller;

  
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SubjectDao;


@WebServlet("/DeleteSubjectController")
public class DeleteSubjectController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer subjectId = Integer.parseInt(request.getParameter("subjectId"));
		SubjectDao dao = new SubjectDao();
		dao.deleteSubjectById(subjectId);
	
		request.getRequestDispatcher("ListSubjectController").forward(request, response);
	}
}