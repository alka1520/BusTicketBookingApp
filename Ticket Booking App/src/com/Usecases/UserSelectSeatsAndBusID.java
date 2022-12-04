package com.Usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Dao.BusRoute;
import com.Dao.BusRouteImpl;
import com.exception.BookingException;

public class UserSelectSeatsAndBusID {
	
	public UserSelectSeatsAndBusID(String date,String uname) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("BusID : ");
		int bid = scn.nextInt();
		
		System.out.print("Total Seats : ");
		int noseats = scn.nextInt();
		
		BusRoute dao = new BusRouteImpl();
		
		try {
			String msg = dao.confirmTotalNoOfSeats(bid, noseats);
			int userid = dao.getUserId(uname);
			
			List<Integer> seats = new ArrayList<>();
			while(noseats > 0) {
				System.out.print("Seat Number : ");
				int seatnumber = scn.nextInt();
				try {
					String d = dao.confirmSeatNumberForReservation(userid,seatnumber,bid,date);
					System.out.println(d);
					seats.add(seatnumber);
					noseats--;
				} catch (BookingException e) {
					System.out.println(e.getMessage());
				}				
			}
			
			System.out.println("Reservation Successfully done...");
			BookTicket bt = new BookTicket(userid,date,uname,bid);
			
		} catch (BookingException e1) {
			System.out.println(e1.getMessage());
		}
		
		
		
	}
	
}
