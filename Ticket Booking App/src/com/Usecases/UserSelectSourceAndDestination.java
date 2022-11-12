package com.Usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Dao.BusRoute;
import com.Dao.BusRouteImpl;
import com.exception.BookingException;
import com.model.BusDetails;

public class UserSelectSourceAndDestination {
	
	public UserSelectSourceAndDestination(String uname) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("_________________________");
		System.out.println("____Reservation Page____ \n");
		
		System.out.print("Date[yyyy-mm-dd] : ");
		String date = scn.next();
		
		System.out.print("Source : ");
		String src= scn.next();
		
		System.out.print("Destination : ");
		String des= scn.next();
				
		BusRoute dao = new BusRouteImpl();
		
		try {
			List<BusDetails> busdata = dao.UserSelectSourceAndDestination(date,src, des);
			busdata.forEach(bdata -> System.out.println(bdata));
			
			System.out.println();
			System.out.println("Enter 1 : Reservation ");
			System.out.println("Enter 0 : Exit ");
			
			int selection = scn.nextInt();
			
			if(selection == 1) {
				UserSelectSeatsAndBusID ssab = new UserSelectSeatsAndBusID(date,uname);
				
			}else if(selection == 0) {
				System.out.println("\n Thank you :)");
				
			}else {
				System.out.println("\n enter valid choice");
			}
			
			
		} catch (BookingException e) {
			System.out.println(e.getMessage());
			
			System.out.println("Enter 1 : Continue \nEnter 0 : Exit ");
			int select = scn.nextInt();
			if(select == 1) {
				UserSelectSourceAndDestination ussad = new UserSelectSourceAndDestination(uname);
			}else if(select == 0) {
				System.out.println("Thank you .");
				return;
			}
			
		}
		
		System.out.println("_________________________");
		
		
		
	
		
	}

}
