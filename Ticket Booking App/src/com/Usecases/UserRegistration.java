package com.Usecases;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Dao.UserDao;
import com.Dao.UserDaoImpl;
import com.exception.AdminException;
import com.exception.UserException;
import com.model.Admin;
import com.model.User;

public class UserRegistration {
	
	public UserRegistration() {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("_________________________");
		System.out.println("____Sign up Page____ \n");
		
		System.out.print("Name : ");
		String name = scn.next();
		
		System.out.print("Username : ");
		String username = scn.next();
		
		System.out.print("Password : ");
		String pword = scn.next();
		
		System.out.print("Contact : ");
		String contact = scn.next();
		
		User user = new User(name,username, pword, contact);
		
		UserDao dao = new UserDaoImpl();
		
		try {
			String result = dao.userRegistration(user);
			System.out.println(result);
			UserSelectSourceAndDestination ussad = new UserSelectSourceAndDestination(username);
			
		} catch (UserException e) {
			System.out.println("\n"+e.getMessage());
		}
		System.out.println("_________________________ \n");
	}
}
