package com.Usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectSeatsAndBusID {
	public static void selectbus(String date) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter BusID, You Want to boook ");
		int bid = scn.nextInt();
		
		System.out.println("Enter total Number of seats you want to reserve ");
		int noseats = scn.nextInt();
		
		System.out.println("Enter seat number you want to reserve ");
		
		while(true) {
			int seatnumber = scn.nextInt();
			
			
			List<Integer> seats = new ArrayList<>();
			
			seats.add(seatnumber);
		}
		
		
	}
}
