package com.Usecases;

import java.util.Scanner;

public class UserPage {
	
	public UserPage() {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("________________________");
		
		while(true) {
			System.out.println("____User Page____ \n");
			System.out.println("Enter 0 : Return");
			System.out.println("Enter 1 : Login");
			System.out.println("Enter 2 : New User");
			int select = scn.nextInt();
			
			if(select == 1) {
				UserLogin la = new UserLogin();
				
			}else if(select == 2) {
				UserRegistration ar = new UserRegistration();
				
			}else if(select == 0){
				System.out.println("Thank You .");
				break;
				
			}else {
				System.out.println("Enter Valid Choice");
			}
		}
		System.out.println("________________________");
	}
	
}
