package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.QuestionBean;
import com.dao.QuestionDao;




@WebServlet("/ListQuestionController")
public class ListQuestionController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuestionDao dao = new QuestionDao();
		ArrayList<QuestionBean> questions = dao.getAllQuestions();
		
		request.setAttribute("questions", questions);
		RequestDispatcher rd = request.getRequestDispatcher("ListQuestion.jsp");
		rd.forward(request, response);
		
	}
}