package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.AdminException;
import com.exception.BookingException;
import com.model.BookingDetails;
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
						
						PreparedStatement ps2 = conn.prepareStatement("select bid,bname,btype,bseats,dtime,atime from busdetails where routId = ?");
						
						ps2.setInt(1, rid);
						ResultSet rs2 = ps2.executeQuery();
						
						while(rs2.next()) {
							int bid = rs2.getInt("bid");
							String bname = rs2.getString("bname");
							String btype = rs2.getString("btype");
							int seats = rs2.getInt("bseats");
							String dtime = rs2.getString("dtime");
							String atime = rs2.getString("atime");
							
							BusDetails bdata = new BusDetails(bid, bname, btype, seats, dtime, atime);
							
							busdata.add(bdata);
							
						}if(busdata.size() == 0){
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
	public String confirmBooking(int bid, int noOfSeats) throws BookingException {
		
		String message = "Error Occurred !";
		
		try(Connection conn = DButil.preConnection()) {
			
			PreparedStatement p = conn.prepareStatement(" select if(? < bseats,'yes','no') as result from busdetails where bid = ?");
			
			p.setInt(1,noOfSeats);
			p.setInt(2,bid);

			ResultSet r = p.executeQuery();
			
			if(r.next() && r.getString("result").contains("yes") ) {
				PreparedStatement ps = conn.prepareStatement("update busdetails set bseats = bseats-? where bid = ?");
				
				ps.setInt(1,noOfSeats);
				ps.setInt(2,bid);

				int x = ps.executeUpdate();
				if(x>0) {
					message = "updated successfully";
				}else {
					throw new BookingException("error occurred !");
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
	public String confirmSeat(int pid, int seat, int bid) throws BookingException {
		
		String msg = "Seat Unavialable";
		
		try(Connection conn = DButil.preConnection()) {
		
			PreparedStatement ps = conn.prepareStatement("select if(? = slable,'yes','no') as result from seatallocation where bid = ?");
			
			ps.setInt(1,seat);
			ps.setInt(2, bid);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String result = rs.getString("result");
				if(result.contains("yes")) {
					throw new BookingException("seat already Allocated, select another one");
				}
			}
				PreparedStatement ps2 = conn.prepareStatement("insert into seatallocation (pid,slable,bid) values(?,?,?)");
				
				ps2.setInt(1, pid);
				ps2.setInt(2, seat);
				ps2.setInt(3, bid);
				
				int x = ps2.executeUpdate();
				if(x>0) {
					msg = "Seat Allocated";
				}else{
					throw new BookingException("Error Occurred !");
				}
				
			}
			 catch (SQLException e) {
			e.printStackTrace();
			throw new BookingException(e.getMessage());
		}
		
		return msg;
	}

	
	
	@Override
	public int InsertPassengerDetails(String name, String email) throws BookingException {
		
		int pid = 0;
		
		try(Connection conn = DButil.preConnection()) {
			
			PreparedStatement p = conn.prepareStatement("insert into pdetails(pname,pemail) values(?,?)");
			
			p.setString(1,name);
			p.setString(2, email);

			int x = p.executeUpdate();
		
			if(x>0) {
				
				PreparedStatement ps = conn.prepareStatement("select pid from pdetails where pemail = ?");
				
				ps.setString(1,email);

				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					 pid = rs.getInt("pid");
				}else {
					throw new BookingException("Error Occurred !");
				}
			}	
				
		}catch(SQLException e) {
			e.printStackTrace();
			throw new BookingException(e.getMessage());
		}
		
		return pid;
		
	}

	@Override
	public List<BookingDetails> bookingDetailsPrint(int pid, String date) throws BookingException {
		
		List<BookingDetails> booking = new ArrayList<>();
		
		try(Connection conn = DButil.preConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select p.pname,s.pid,s.tid,s.slable,b.bname,b.atime,b.dtime,b.btype,r.source,r.destination from pdetails p INNER JOIN seatAllocation s INNER JOIN busdetails b INNER JOIN busroute r ON p.pid = s.pid AND b.bid = s.bid AND b.routId = r.routId AND p.pid = ?");
			
			ps.setInt(1, pid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String pname = rs.getString("pname");
				int tid = rs.getInt("tid");
				int slable = rs.getInt("slable");
				String bname = rs.getString("bname");
				String atime = rs.getString("atime");
				String dtime = rs.getString("dtime");
				String btype = rs.getString("btype");
				String source = rs.getString("source");
				String destination = rs.getString("destination");
				
				BookingDetails bd = new BookingDetails(pid, tid, pname, bname, btype,atime,dtime, date, source, destination, slable);
				booking.add(bd);
			}
			if(booking.size() == 0) {
				throw new BookingException("can't book ticket.. Error Found");
			}
			
		 }catch (SQLException e) {
			throw new BookingException(e.getMessage());
		}
		
		return booking;
	}

	@Override
	public String cancelBooking(int pid) throws BookingException {
		String msg = "Error Occurred !";
		
		try(Connection conn = DButil.preConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select bid,count(pid) from seatallocation where pid = ? ");
			
			ps.setInt(1, pid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int bid = rs.getInt("bid");
				int pid_count = rs.getInt("count(pid)");
				
				PreparedStatement ps2 = conn.prepareStatement("Delete from seatallocation where pid = ? ");
				
				ps2.setInt(1, pid);
				
				int x = ps.executeUpdate();
				
				if(x > 0) {
					PreparedStatement ps3 = conn.prepareStatement("update busdetails set bseats = bseats+? where bid = ?");
					
					ps3.setInt(1, pid_count);
					ps3.setInt(2, bid);
					
					int ux = ps3.executeUpdate();
					
					if(ux > 0) {
						msg = "Booking cancelled..";
					}else {
						throw new BookingException("Error Occurred...");
					}
				}
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BookingException(e.getMessage());
		}
				
		return msg;
	}


}
