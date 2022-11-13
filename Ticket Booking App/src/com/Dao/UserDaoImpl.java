package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.AdminException;
import com.exception.UserException;
import com.model.Admin;
import com.model.User;
import com.utililty.DButil;

public class UserDaoImpl implements UserDao{

	@Override
	public String userRegistration(User user) throws UserException {
		String result = "not registered";
		
		try(Connection conn = DButil.preConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into user(username,password,contact,name) values (?,?,?,?)");
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getContact());
			ps.setString(4, user.getName());
			
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				result = "registered successfully !";
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new UserException(e.getMessage());
		}
		
		
		return result;
	}

	@Override
	public User userLogin(String username, String pword) throws UserException {
		User user = null;
		
		try(Connection conn = DButil.preConnection()) {
			PreparedStatement ps = conn.prepareStatement("select username from user where username = ? ");
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String un = rs.getString("username"); 
				PreparedStatement ps2 = conn.prepareStatement("select * from user where password = ? AND username = ?");
				
				ps2.setString(1, pword);
				ps2.setString(2, un);
				
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next()) {
				
				   int id = rs2.getInt("userid");
				   String uname = rs2.getString("username");
				   String contact = rs2.getString("contact");
				   
				   user = new User(id,username,contact);
				   
				}else {
					throw new UserException("Invalid password !");
				}
			}else {
				throw new UserException("Invalid username !");	
			}
				
		}catch(SQLException e) {
			
			throw new UserException("Error Occured ! try again");
		}
		
		
		return user;
	}

}
