package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.SubjectBean;
import com.util.DbConnection;

public class SubjectDao {

	public void InsertSub(SubjectBean sub) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into Subjects (SubjectName) values (?)");

			pstmt.setString(1, sub.getSubjectName());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<SubjectBean> getAllSubjects() {
		ArrayList<SubjectBean> subjects = new ArrayList<SubjectBean>();

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from subjects");
			ResultSet rs = pstmt.executeQuery();// ResultSet

			while (rs.next()) {// false -> loop stop
				SubjectBean sub = new SubjectBean();
				sub.setSubjectId(rs.getInt("SubjectId"));
				sub.setSubjectName(rs.getString("SubjectName"));
				subjects.add(sub);
			}

		} catch (Exception e) {
			System.out.println("ERROR in getAllUsers()");
			e.printStackTrace();
		}

		return subjects;
	}

	public void deleteSubjectById(Integer subjectId) {
		try {

			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from subjects where subjectId = ?");
			pstmt.setInt(1, subjectId);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}