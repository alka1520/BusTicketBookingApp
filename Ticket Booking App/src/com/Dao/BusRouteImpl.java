package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.AdminException;
import com.exception.BookingException;
import com.model.BusDetails;
import com.utililty.DButil;

public class BusRouteImpl implements BusRoute{

	@Override
	public List<BusDetails> UserSelectSourceAndDestination(String date, String src, String dest) throws BookingException{
		List<BusDetails> busdata = new ArrayList<>();
		
		
		try(Connection conn = DButil.preConnection()) {
						
			PreparedStatement p = conn.prepareStatement("select if(? > sysdate(),'yes','no')as abc");
			
			p.setString(1,date);
			ResultSet r = p.executeQuery();
			
			if(r.next() && r.getString("abc").contains("yes") ) {
									
					PreparedStatement ps = conn.prepareStatement("select routId from busroute where source = ? AND destination = ?");
					
					ps.setString(1, src);
					ps.setString(2, dest);
					
					ResultSet rs = ps.executeQuery();
					
					if(rs.next()) {
						int rid = rs.getInt("routId");
						System.out.println(rid);
						PreparedStatement ps2 = conn.prepareStatement("select bid,bname,btype,bseats,dtime,atime from busdetails where routId = ?");
						
						ps2.setInt(1, rid);
						ResultSet rs2 = ps2.executeQuery();
						
						if(rs2.next()) {
							int bid = rs2.getInt("bid");
							String bname = rs2.getString("bname");
							String btype = rs2.getString("btype");
							int seats = rs2.getInt("bseats");
							String dtime = rs2.getString("dtime");
							String atime = rs2.getString("atime");
							
							BusDetails bdata = new BusDetails(bid, bname, btype, btype, dtime, atime);
							
							busdata.add(bdata);
							
						}else{
							throw new BookingException("No Bus alloted to this route !");
						}
					}
					else {
						throw new BookingException("can't find the route :( ");
					}
				}else {
					throw new BookingException("no booking available for today");
				}
			
			
		 }catch (SQLException e) {
			throw new BookingException(e.getMessage());
		}
		
		
		return busdata;
	}

	@Override
	public String confirmBooking(int bid, int noOfSeats, List<Integer> seats) throws BookingException {
		
		String message = "Error Occurred !";
		
		try(Connection conn = DButil.preConnection()) {
			
			PreparedStatement p = conn.prepareStatement(" select if(? < bseats,'yes','no') as result from busdetails where bid = ?");
			
			p.setInt(1,noOfSeats);
			p.setInt(2,bid);

			ResultSet r = p.executeQuery();
			
			if(r.next() && r.getString("result").contains("yes") ) {
				
				for(int label:seats) {
					PreparedStatement p = conn.prepareStatement(" select if(? < bseats,'yes','no') as result from busdetails where bid = ?");
					
					p.setInt(1,noOfSeats);
					p.setInt(2,bid);

					ResultSet r = p.executeQuery();
				}
			}
			else {
				throw new BookingException("Unsufficient Seats !");
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BookingException(e.getMessage());
		}
		
		
		return message;
		
	}

	@Override
	public String confirmSeat(int seat, int bid) throws BookingException {
		String msg = "Seat Unavialable";
		
		try(Connection conn = DButil.preConnection()) {
			
			PreparedStatement p = conn.prepareStatement(" select if(? = slable,'yes','no') as result from seatallocation where bid = ?");
			
			p.setInt(1,seat);
			p.setInt(2, bid);

			ResultSet r = p.executeQuery();
			
			if(r.next() && r.getString("result").contains("no")) {
				PreparedStatement ps = conn.prepareStatement("select routId from busroute where source = ? AND destination = ?");
				
				ps.setString(1, src);
				ps.setString(2, dest);
				
				ResultSet rs = ps.executeQuery();
			}
			else {
				throw new BookingException("seat already Allocated, select another one");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BookingException(e.getMessage());
		}
		
		
		
		return msg;
	}


}
