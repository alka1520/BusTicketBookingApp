package com.Usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Dao.BusRoute;
import com.Dao.BusRouteImpl;
import com.exception.BookingException;

public class SelectSeatsAndBusID {
	
	public static void selectbus(String date) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter BusID, You Want to book ");
		int bid = scn.nextInt();
		
		System.out.println("Enter total Number of seats you want to reserve ");
		int noseats = scn.nextInt();
		
		BusRoute dao = new BusRouteImpl();
		
		try {
			String msg = dao.confirmTotalNoOfSeats(bid, noseats);
			
			System.out.println("Enter passenger name");
			String name = scn.next();
			
			System.out.println("Enter email");
			String email = scn.next();
			
			int pid = dao.InsertPassengerDetails(name, email);
			
			
			System.out.println("Enter seat number you want to reserve ");
			
			List<Integer> seats = new ArrayList<>();
			while(noseats-- > 0) {
				
				int seatnumber = scn.nextInt();
				
				try {
					String d = dao.confirmSeatNumberForReservation(pid,seatnumber, bid);
					seats.add(seatnumber);
				} catch (BookingException e) {
					System.out.println(e.getMessage());
					noseats++;
				}				
			}
			
			System.out.println("Enter 1 to Book Ticket ");
			if(scn.nextInt() == 1) {
				BookTicket bt = new BookTicket();
				bt.BookTicket(pid,date);
			}
			
			
		} catch (BookingException e1) {
			System.out.println(e1.getMessage());
		}
		
		
		
		
	}
}
