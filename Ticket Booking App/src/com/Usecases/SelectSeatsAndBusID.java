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
		
		System.out.println("Enter BusID, You Want to boook ");
		int bid = scn.nextInt();
		
		System.out.println("Enter total Number of seats you want to reserve ");
		int noseats = scn.nextInt();
		
		System.out.println("Enter seat number you want to reserve ");
		List<Integer> seats = new ArrayList<>();
		while(noseats-- > 0) {
			int seatnumber = scn.nextInt();
			
			BusRoute dao = new BusRouteImpl();
			try {
				String d = dao.confirmSeat(seatnumber, bid);
				seats.add(seatnumber);
			} catch (BookingException e) {
				System.out.println(e.getMessage());
			}
			
			
			
		}
		
		
	}
}
