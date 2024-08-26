package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {

	public void addUser(UserBean user) {

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"insert into users (firstName,lastName,email,password,gender,city,contactNum,role) values (?,?,?,?,?,?,?,?)");

			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getCity());
			pstmt.setString(7, user.getContactNum());
			pstmt.setString(8, user.getRole());

			pstmt.executeUpdate();// this will execute your query into database

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserBean getUserByEmail(String email) {

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? ");

			pstmt.setString(1, email);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				UserBean userBean = new UserBean();
				userBean.setFirstName(rs.getString("firstName"));
				userBean.setEmail(email);
				userBean.setCity(rs.getString("city"));
				userBean.setContactNum(rs.getString("contactNum"));
				userBean.setGender(rs.getString("gender"));
				userBean.setLastName(rs.getString("lastName"));
				userBean.setRole(rs.getString("role"));
				userBean.setUserId(rs.getInt("userId"));
				return userBean;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateOtp(String otp, String email) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set otp = ? where email = ?  ");
			pstmt.setString(1, otp);
			pstmt.setString(2, email);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updatePassword(UserBean user) {

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update users set password = ? where email = ?  ");
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getEmail());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkOTP(UserBean user) {

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and otp =  ? ");

			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getOtp());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			}else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
