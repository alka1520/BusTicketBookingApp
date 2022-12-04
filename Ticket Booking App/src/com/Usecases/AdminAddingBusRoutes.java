package com.Usecases;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.exception.AdminException;

public class AdminAddingBusRoutes {
	
	public AdminAddingBusRoutes(String contact) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("___________________________");
		System.out.println("____Enter Bus Details____ \n");
		
		System.out.print("From : ");
		String from = sc.next();
		
		System.out.print("To : ");
		String to = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		int routeid;
		try {
			 routeid =  dao.addNewRoute(from, to);
			 AdminAddingBusDetails aabd = new AdminAddingBusDetails(routeid,contact);
			
		} catch (AdminException e) {
			System.out.println(e.getMessage());

			
		}
		finally {
			System.out.println("___________________________");
			
			while(true) {
				System.out.println("Enter 1 to Add Bus Details");
				System.out.println("Enter 0 to Return");
				int select = sc.nextInt();
				if(select == 1) {
					AdminAddingBusRoutes aabr = new AdminAddingBusRoutes(contact);
				}
				break;
			}
		}
	}
}
