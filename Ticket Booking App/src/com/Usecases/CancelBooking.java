package com.Usecases;

import java.util.List;
import java.util.Scanner;

import com.Dao.BusRoute;
import com.Dao.BusRouteImpl;
import com.exception.BookingException;
import com.model.BookingDetails;

public class CancelBooking {

	public CancelBooking(String uname) {
		Scanner scn = new Scanner(System.in);
		System.out.println("_________________________");

		BusRoute dao = new BusRouteImpl();
		
		try {
			int userid = dao.getUserId(uname);
			String date = dao.getBookingDatebyuserid(userid);
			List<BookingDetails> booking = dao.bookingDetailsPrint(userid,date,uname);
			booking.forEach(ticketDetails -> System.out.println(ticketDetails));
			
			System.out.println("\nEnter 1 : confirming cancel");
			System.out.println("Enter 0 : Exit");
			int select = scn.nextInt();
			if(select == 1) {
				String msg = dao.cancelBooking(userid);
				System.out.println("\n Booking Cancelation successfull .");
			}else {
				System.out.println("\n Thank you :)");
			}
			
		} catch (BookingException e) {
			System.out.println(e.getMessage());
		}
		

	}
}
