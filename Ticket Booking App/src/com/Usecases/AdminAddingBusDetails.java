package com.Usecases;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.exception.AdminException;
import com.model.BusDetails;

public class AdminAddingBusDetails {

	public AdminAddingBusDetails(int broute,String contact) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Bus Name : ");
		String bname = scn.next();
		
		System.out.print("Bus Type : ");
		String bustype = scn.next();
		
		System.out.print("Departure Time(HH:MM:SS) : ");
		String dtime = scn.next();
		
		System.out.print("Arrival Time(HH:MM:SS) : ");
		String atime = scn.next();
		
		System.out.print("Total Seats : ");
		int bseats = scn.nextInt();
		
		BusDetails bdetails = new BusDetails(bname, bustype, broute, bseats, dtime, atime,contact);
		AdminDao dao = new AdminDaoImpl();
		
		try {
			String msg = dao.insertBusDetails(bdetails);
			System.out.println(msg);
			System.out.println("\n ______________________________ \n");
			
		} catch (AdminException e) {
			System.out.println(e.getMessage());
			
		}
		
	}
}
