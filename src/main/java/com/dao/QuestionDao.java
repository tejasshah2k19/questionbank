
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.QuestionBean;
import com.util.DbConnection;

public class QuestionDao {

	public void InsertQue(QuestionBean que) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement
	("insert into questions (question,explanation,example1,example2,subject,topic,difficulty) values (?,?,?,?,?,?,?)");
			pstmt.setString(1,que.getQuestion());
			pstmt.setString(2,que.getExplanation());
			pstmt.setString(3,que.getExample1());
			pstmt.setString(4,que.getExample2());
			pstmt.setString(5,que.getSubject());
			pstmt.setString(6,que.getTopic());
			pstmt.setString(7,que.getDifficulty());
			
			pstmt.executeUpdate(); 

		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	public ArrayList<QuestionBean> getAllQuestions() {
		ArrayList<QuestionBean> questions = new ArrayList<QuestionBean>();
		
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from questions");
			ResultSet rs = pstmt.executeQuery();// ResultSet

			while (rs.next()) {// false -> loop stop
				QuestionBean que = new QuestionBean();
				que.setQueId(rs.getInt("queId"));
				que.setQuestion(rs.getString("question"));
				que.setExplanation(rs.getString("explanation"));
				que.setExample1(rs.getString("example1"));
				que.setExample2(rs.getString("example2"));
				que.setSubject(rs.getString("subject"));
				que.setTopic(rs.getString("topic"));
				que.setDifficulty(rs.getString("difficulty"));
				questions.add(que);
			}

		} catch (Exception e) {
			System.out.println("ERROR in getAllUsers()");
			e.printStackTrace();
		}

		return questions;
	}

	public void deleteQuestionById(Integer queId) {
		try {

			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from questions where queId = ?");
			pstmt.setInt(1, queId);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}