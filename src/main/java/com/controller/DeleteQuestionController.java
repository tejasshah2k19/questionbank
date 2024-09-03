
package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.QuestionDao;

@WebServlet("/DeleteQuestionController")
public class DeleteQuestionController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer queId = Integer.parseInt(request.getParameter("queId"));
		QuestionDao dao = new QuestionDao();
		dao.deleteQuestionById(queId);

		request.getRequestDispatcher("ListQuestionController").forward(request, response);
	}
}