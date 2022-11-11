package com.Usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Dao.BusRoute;
import com.Dao.BusRouteImpl;
import com.exception.BookingException;
import com.model.BusDetails;

public class UserSelectSourceAndDestination {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("enter date in yyyy-mm-dd format");
		String date = scn.next();
		
		System.out.println("enter source");
		String src= scn.next();
		
		System.out.println("enter destination");
		String des= scn.next();
				
		BusRoute dao = new BusRouteImpl();
		
		try {
			List<BusDetails> busdata = dao.UserSelectSourceAndDestination(date,src, des);
			busdata.forEach(bdata -> System.out.println(bdata));
			
			System.out.println("Enter 1 to book bus :)");
			System.out.println("Enter 2 to Exit :(");
			
			int selection = scn.nextInt();
			
			if(selection == 1) {
				SelectSeatsAndBusID ssab = new SelectSeatsAndBusID();
				ssab.selectbus(date);
				
			}else if(selection == 2) {
				System.out.println("Thank you :)");
			}else {
				System.out.println("enter valid choice");
			}
			
			
		} catch (BookingException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	
	}

}
