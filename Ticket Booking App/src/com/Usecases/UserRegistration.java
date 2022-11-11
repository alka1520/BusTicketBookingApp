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
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("enter name");
		String name = scn.next();
		
		System.out.println("enter password");
		String pword = scn.next();
		
		System.out.println("enter email");
		String email = scn.next();
		
		User user = new User(name, email, pword);
		
		UserDao dao = new UserDaoImpl();
		
		try {
			String result = dao.userRegistration(user);
			System.out.println(result);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
	}
}
