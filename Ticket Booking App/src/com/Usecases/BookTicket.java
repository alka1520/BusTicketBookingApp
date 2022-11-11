package com.Usecases;

import java.util.List;
import java.util.Scanner;

import com.Dao.BusRoute;
import com.Dao.BusRouteImpl;
import com.exception.BookingException;
import com.model.BookingDetails;

public class BookTicket {
	
	public static void BookTicket(int pid,String date) {
		
		Scanner scn = new Scanner(System.in);
		BusRoute dao = new BusRouteImpl();
		try {
			List<BookingDetails> booking = dao.bookingDetailsPrint(pid,date);
			booking.forEach(ticketDetails -> System.out.println(ticketDetails));
			
			System.out.println("enter 1 to cancel booking");
			
			if(scn.nextInt() == 1) {
				String cBooking = dao.cancelBooking(pid);
				System.out.println(cBooking);
			}
		} catch (BookingException e) {
			System.out.println(e.getMessage());
		}
	}

}
