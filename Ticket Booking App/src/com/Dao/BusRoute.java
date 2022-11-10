package com.Dao;

import java.util.List;

import com.exception.AdminException;
import com.exception.BookingException;
import com.model.BusDetails;

public interface BusRoute {
	
	public List<BusDetails> UserSelectSourceAndDestination(String date, String src, String dest) throws BookingException;

	public String confirmBooking(int bid, int noOfSeats, List<Integer> seats) throws BookingException;
	
	public String confirmSeat(int seat, int bid) throws BookingException;

}
