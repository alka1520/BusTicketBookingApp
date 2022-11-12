package com.Usecases;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.exception.AdminException;
import com.model.Admin;

public class AdminRegistration {
	
	public AdminRegistration() {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("_________________________");
		System.out.println("____Sign up Page____ \n");
		
		System.out.print("Enter name : ");
		String name = scn.next();
		
		System.out.print("Enter username : ");
		String uname = scn.next();
		
		System.out.print("Enter password : ");
		String pword = scn.next();
		
		System.out.print("Enter contact : ");
		String phn = scn.next();
		
		System.out.print("Enter email : ");
		String email = scn.next();
		
		Admin admin = new Admin();
		admin.setName(name);
		admin.setUname(uname);
		admin.setPassword(pword);
		admin.setContact(phn);
		admin.setEmail(email);
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			String result = dao.adminRegistration(admin);
			System.out.println(result);
			AdminLogin la = new AdminLogin();
			
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("_________________________");
		}
		
	}
			
}
