package com.Usecases;

import java.util.Scanner;

public class MainBusTicketRerservation {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("____Home Page____ \n");
			System.out.println("Enter 1 to Bus Reservation query .");
			System.out.println("Enter 2 to Add Bus Details/Admin .");
			System.out.println("Enter 0 to Exit .");
			
			// "select" to take the input from user
			
			int select = scn.nextInt();
			
			if(select == 1) {
				UserPage up = new UserPage();
				
			}else if(select == 2) {
				AdminPage adp = new AdminPage();
				
			}else if(select == 0){
				System.out.println("Thank You .");
				break;
			}else {
				System.out.println("Enter Valid Choice !");
			}
		}
		
	}
}
