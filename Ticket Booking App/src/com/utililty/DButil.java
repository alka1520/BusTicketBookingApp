package com.utililty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DButil {
	    private static String url;
	    private static String driverName;
	    private static String username;
	    private static String password;
	    
	    static {
	        
	        ResourceBundle rb= ResourceBundle.getBundle("dbdetails");
	        
	        url= rb.getString("db.url");
	        driverName= rb.getString("db.drivername");
	        username= rb.getString("db.username");
	        password= rb.getString("db.password");
	        
	        
	        
	    }
	public static Connection preConnection() {
		
		Connection conn = null;
		
		try {
			
			Class.forName(driverName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		try {
			
			conn= DriverManager.getConnection(url,username,password);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}

}
