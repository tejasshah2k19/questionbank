package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.QuestionBean;
import com.bean.SubjectBean;
import com.dao.QuestionDao;
import com.dao.SubjectDao;
import com.util.ValidationUtil;

@WebServlet("/AddQuestionController")
public class AddQuestionController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String question = request.getParameter("question");
		String explanation = request.getParameter("explanation");
		String example1 = request.getParameter("example1");
		String example2 = request.getParameter("example2");
		String subject = request.getParameter("subject");
		String topic = request.getParameter("topic");
		String difficulty = request.getParameter("difficulty");

		boolean isError = false;

		if (ValidationUtil.isEmpty(question)) {
			isError = true;
			request.setAttribute("queError", "Please Enter Question");
		}
		if (ValidationUtil.isEmpty(explanation)) {
			isError = true;
			request.setAttribute("expError", "Please Enter Explanation");
		}
		if (ValidationUtil.isEmpty(example1)) {
			isError = true;
			request.setAttribute("ex1Error", "Please Enter Example 1");
		}
		if (ValidationUtil.isEmpty(example2)) {
			isError = true;
			request.setAttribute("ex2Error", "Please Enter Example 2");
		}

		if (ValidationUtil.isEmpty(subject)) {
			isError = true;
			request.setAttribute("subError", "Please Enter Subject");
		}
		if (ValidationUtil.isEmpty(topic)) {
			isError = true;
			request.setAttribute("topError", "Please Enter Topic");
		}
		if (ValidationUtil.isEmpty(difficulty)) {
			isError = true;
			request.setAttribute("difError", "Please Enter Difficulty");
		}

		if (isError == true) {
			QuestionBean que = new QuestionBean();
			que.setQuestion(question);
			que.setExplanation(explanation);
			que.setExample1(example1);
			que.setExample2(example2);
			que.setSubject(subject);
			que.setTopic(topic);
			que.setDifficulty(difficulty);
			que.setDifficulty(difficulty);
			request.setAttribute("que", que);
			request.getRequestDispatcher("NewQuestion.jsp").forward(request, response);

		} else {
			QuestionBean que = new QuestionBean();
			que.setQuestion(question);
			que.setExplanation(explanation);
			que.setExample1(example1);
			que.setExample2(example2);
			que.setSubject(subject);
			que.setTopic(topic);
			que.setDifficulty(difficulty);
			que.setDifficulty(difficulty);
			QuestionDao dao = new QuestionDao();
			dao.InsertQue(que);
			request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
		}

	}
}