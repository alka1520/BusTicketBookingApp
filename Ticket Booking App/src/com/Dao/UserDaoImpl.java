package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.exception.AdminException;
import com.exception.UserException;
import com.model.User;
import com.utililty.DButil;

public class UserDaoImpl implements UserDao{

	@Override
	public String userRegistration(User user) throws UserException {
		String result = "not registered";
		
		try(Connection conn = DButil.preConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into pdetails(pname,pemail,ppword) values (?,?,?)");
			
			ps.setString(1, user.getPname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPword());
			
			
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

}
