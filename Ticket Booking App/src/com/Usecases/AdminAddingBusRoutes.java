package com.Usecases;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.exception.AdminException;

public class AdminAddingBusRoutes {
	
	public AdminAddingBusRoutes(String contact) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("____Enter Route Details____ \n");
		
		System.out.print("From : ");
		String from = scn.next();
		
		System.out.print("To : ");
		String to = scn.next();
		
		AdminDao dao = new AdminDaoImpl();
		int routeid;
		try {
			 routeid =  dao.addNewRoute(from, to);
			AdminAddingBusDetails aabd = new AdminAddingBusDetails(routeid,contact);
			
		} catch (AdminException e) {
			System.out.println(e.getMessage());

			
		}
		finally {
			System.out.println("Enter 1 to Add Bus Details");
			System.out.println("Enter 0 to Return");
			
			while(true) {
				int select = scn.nextInt();
				if(select == 1) {
					AdminAddingBusRoutes aabr = new AdminAddingBusRoutes(contact);
				}else if(select == 0){
					break;
				}else {
					System.out.println("Please enter valid choice");
				}
			}
			return;
			
		}
	}
}
