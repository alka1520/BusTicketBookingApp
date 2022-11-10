package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.AdminException;
import com.model.Admin;
import com.utililty.DButil;

public class AdminDaoImpl implements AdminDao{
	
	@Override
	public String adminRegistration(Admin admin) throws AdminException {
		
		String result = "not registered";
		
		try(Connection conn = DButil.preConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into admin(name,username,password,contact,email) values (?,?,?,?,?)");
			
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getUname());
			ps.setString(3, admin.getPassword());
			ps.setString(4, admin.getContact());
			ps.setString(5, admin.getEmail());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				result = "registered successfully !";
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		
		
		return result;
		
	}


	@Override
	public Admin login(String uname, String pword) throws AdminException {
		
		Admin admin = null;
		
		try(Connection conn = DButil.preConnection()) {
			PreparedStatement ps = conn.prepareStatement("select username from admin where username = ? ");
			
			ps.setString(1, uname);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String username = rs.getString("username"); 
				PreparedStatement ps2 = conn.prepareStatement("select * from admin where password = ? AND username = username");
				
				ps2.setString(1, pword);
				
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next()) {
				
				   String name = rs2.getString("name");
				   String password = rs2.getString("password");
				   String contact = rs2.getString("contact");
				   String email = rs2.getString("email");
				   
				   admin = new Admin(username, uname, password, email, contact);
				   
				}else {
					throw new AdminException("Invalid password !");
				}
			}else {
				throw new AdminException("Invalid username !");	
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		
		
		return admin;
	}
	
	


	@Override
	public String insertBusDetails() throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String addNewRoute(String src, String dest) throws AdminException{
		String result = "Unable to Add New Route !";
		
		try(Connection conn = DButil.preConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into busroute(source,destination) values(?,?)");
			
			ps.setString(1, src);
			ps.setString(2,dest);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				result = "Route Added Successfully !";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AdminException(result);
		}
		
		
		return result;
	}

}
