package com.Usecases;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.exception.AdminException;
import com.model.Admin;

public class LoginAdmin {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("enter username");
		String uname = scn.next();
		
		System.out.println("enter password");
		String pword = scn.next();
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			Admin adminDetails = dao.login(uname, pword);
			System.out.println("Welcome "+adminDetails.getUname()+" :)");
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
