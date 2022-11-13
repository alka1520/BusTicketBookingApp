package com.Usecases;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.exception.AdminException;
import com.model.BusDetails;

public class AdminAddingBusDetails {

	public AdminAddingBusDetails(int broute,String contact) {
		
		Scanner scnn = new Scanner(System.in);
		System.out.print("Bus Name : ");
		String bname = scnn.nextLine();
		
		System.out.print("Bus Type(AC/non-AC) : ");
		String bustype = scnn.next();
		
		System.out.print("Departure Time(HH:MM:SS) : ");
		String dtime = scnn.next();
		
		System.out.print("Arrival Time(HH:MM:SS) : ");
		String atime = scnn.next();
		
		System.out.print("Total Seats : ");
		int bseats = scnn.nextInt();
		System.out.println();
		
		BusDetails bdetails = new BusDetails(bname, bustype, broute, bseats, dtime, atime,contact);
		AdminDao dao = new AdminDaoImpl();
		
		try {
			String msg = dao.insertBusDetails(bdetails);
			System.out.println(msg);
			
		} catch (AdminException e) {
			System.out.println(e.getMessage());
			
		}finally {
			System.out.println("\n _____________________________ \n");
		}
		
	}
}
