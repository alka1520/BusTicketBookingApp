package com.Usecases;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.exception.AdminException;
import com.model.Admin;

public class AdminLogin {
	
	public AdminLogin() {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("_________________________");
		System.out.println("____Log IN Page____ \n");
		
		System.out.print("enter username : ");
		String uname = scn.next();
		
		System.out.print("enter password : ");
		String pword = scn.next();
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			Admin adminDetails = dao.login(uname, pword);
			System.out.println("\n Welcome "+adminDetails.getUname()+ "\n");
			String contact = adminDetails.getContact();
			AdminAddingBusRoutes aabr = new AdminAddingBusRoutes(contact);
			
		} catch (AdminException e) {
			System.out.println(e.getMessage());
			
		}finally {
			System.out.println("_________________________");
		}
		
	}
	
}
