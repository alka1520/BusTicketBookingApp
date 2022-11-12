package com.Dao;

import com.exception.*;
import com.model.Admin;
import com.model.BusDetails;

public interface AdminDao {

	public String adminRegistration(Admin admin) throws AdminException;
	
	public Admin login(String uname, String pword) throws AdminException;
	
	public String insertBusDetails(BusDetails bdetails) throws AdminException;
	
	public int addNewRoute(String src, String dest) throws AdminException;
}
