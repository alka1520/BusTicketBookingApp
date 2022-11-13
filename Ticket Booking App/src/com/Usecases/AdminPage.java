package com.Usecases;

import java.util.Scanner;

public class AdminPage {
	
	public AdminPage() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("________________________\n");
		
		while(true) {
			
			System.out.println("Enter 0 : Exit");
			System.out.println("Enter 1 : Login");
			System.out.println("Enter 2 : New Admin/Sign up");
			int select = s.nextInt();
			
			if(select == 1) {
				AdminLogin la = new AdminLogin();
				
			}else if(select == 2) {
				AdminRegistration ar = new AdminRegistration();
				
			}else if(select == 0){
				break;
				
			}else {
				System.out.println("Enter Valid Choice");
			}
		}
		System.out.println("________________________");
	}
}
