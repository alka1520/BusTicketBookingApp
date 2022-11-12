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

public class UserLogin {
	
	public UserLogin() {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("_________________________");
		System.out.println("____Login Page____ \n");
		
		System.out.print("Username : ");
		String uname = scn.next();
		
		System.out.print("Password : ");
		String pword = scn.next();
		
		UserDao dao = new UserDaoImpl();
		
		try {
			User udetail = dao.userLogin(uname, pword);
			System.out.println("\n Welcome "+udetail.getUsername()+ "\n");
			
			System.out.println("Enter 1 : Cancel Booking");
			System.out.println("Enter 2 : Reservation ");
			
			int select = scn.nextInt();
			
			if(select == 1) {
				CancelBooking sb = new CancelBooking(uname);
			}else if(select == 2) {
				UserSelectSourceAndDestination ussad = new UserSelectSourceAndDestination(uname);
			}
			
		} catch (UserException e) {
			System.out.println("\n"+e.getMessage());
			
		}finally {
			System.out.println("_________________________");
		}
	}
}
