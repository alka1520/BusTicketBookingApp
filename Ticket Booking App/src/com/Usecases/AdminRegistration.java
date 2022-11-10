package com.Usecases;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.exception.AdminException;
import com.model.Admin;

public class AdminRegistration {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("enter name");
		String name = scn.next();
		
		System.out.println("enter username");
		String uname = scn.next();
		
		System.out.println("enter password");
		String pword = scn.next();
		
		System.out.println("enter contact");
		String phn = scn.next();
		
		System.out.println("enter email");
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
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
	}
}
