package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.AdminException;
import com.model.Admin;
import com.model.BusDetails;
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
				result = "Registered successfully !";
			}
			
		}catch(SQLException e) {

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
			
			throw new AdminException("Error Occured ! try again");
		}
		
		
		return admin;
	}
	
	


	@Override
	public String insertBusDetails(BusDetails bdetails) throws AdminException {
		String msg = "Error occured .";
				
		try(Connection conn = DButil.preConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into busdetail(bname,routId,btype,bseats,dtime,atime,helpline) values(?,?,?,?,?,?,?)");
			
			ps.setString(1, bdetails.getBusName());
			ps.setInt(2, bdetails.getRouteId());
			ps.setString(3, bdetails.getBusType());
			ps.setInt(4, bdetails.getBusSeats());
			ps.setString(5,bdetails.getDepartureTime());
			ps.setString(6,bdetails.getArrivalTime());
			ps.setString(7,bdetails.getHelpline());
			
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				msg = "Bus Added Successfully !";
			}
			else {
				throw new AdminException("Error Occured !...\n Please Try Again !");
			}
			
		} catch (SQLException e) {

			throw new AdminException(e.getMessage());
		}

	    return msg;
	}
	
	@Override
	public int addNewRoute(String src, String dest) throws AdminException{
		int routeid = 0;
		
		try(Connection conn = DButil.preConnection()) {
			
			PreparedStatement p = conn.prepareStatement("select routId from busroute where source = ? AND destination = ?");
			
			p.setString(1, src);
			p.setString(2,dest);
			
			ResultSet r = p.executeQuery();
			if(r.next()) {
				routeid = r.getInt("routId");
			}else {
				PreparedStatement ps = conn.prepareStatement("insert into busroute(source,destination) values(?,?)");
				
				ps.setString(1, src);
				ps.setString(2,dest);
				
				int x = ps.executeUpdate();
				
				if(x >0 || x == 0) {
					
					PreparedStatement ps2 = conn.prepareStatement("select routId from busroute where source = ? AND destination = ?");
					
					ps2.setString(1, src);
					ps2.setString(2,dest);
					
					ResultSet rs = ps2.executeQuery();
					if(rs.next()) {
						routeid = rs.getInt("routId");
					}else {
						throw new AdminException("Error Occured !...\nPlease Try Again !");
					}
			    }
			
			}
		} catch (SQLException e) {
			throw new AdminException("Route Available !");
		}
		
		
		return routeid;
	}

}
