package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection getConnection() {

		String driverClass = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/questionbank";
		String dbUserName = "root";
		String dbPassword = "root";

		try {
			Class.forName(driverClass);// load driver class

			Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
