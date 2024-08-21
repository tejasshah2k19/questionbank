package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {

	public void addUser(UserBean user) {

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into users (firstName,lastName,email,password,gender,city,contactNum,role) values (?,?,?,?,?,?,?,?)");
			
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getCity());
			pstmt.setString(7, user.getContactNum());
			pstmt.setString(8, user.getRole());
			
			pstmt.executeUpdate();//this will execute your query into database 	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
