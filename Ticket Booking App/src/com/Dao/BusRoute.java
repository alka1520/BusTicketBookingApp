package com.Dao;

import java.util.List;

import com.exception.AdminException;
import com.exception.BookingException;
import com.model.BookingDetails;
import com.model.BusDetails;

public interface BusRoute {
	
	public List<BusDetails> UserSelectSourceAndDestination(String date, String src, String dest) throws BookingException;

	public String confirmTotalNoOfSeats(int bid, int noOfSeats) throws BookingException;
	
	public int InsertPassengerDetails(String name, String email) throws BookingException;
	
	public String confirmSeatNumberForReservation(int pid, int seat, int bid) throws BookingException;
	
	public List<BookingDetails> bookingDetailsPrint(int pid,String date) throws BookingException;
	
	public String cancelBooking(int pid) throws BookingException;

}
