package com.Dao;

import com.exception.*;
import com.model.Admin;

public interface AdminDao {

	public String adminRegistration(Admin admin) throws AdminException;
	
	public Admin login(String uname, String pword) throws AdminException;
	
	public String insertBusDetails() throws AdminException;
	
	public String addNewRoute(String src, String dest) throws AdminException;
}
