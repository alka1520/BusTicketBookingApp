package com.utililty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	
	public static Connection preConnection() {
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/sb101db";
		
		try {
			
			conn= DriverManager.getConnection(url,"root","1520sql");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}

}
