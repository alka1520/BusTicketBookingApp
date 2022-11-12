package com.Dao;

import com.exception.AdminException;
import com.exception.UserException;
import com.model.Admin;
import com.model.User;

public interface UserDao {
	
	public String userRegistration(User user) throws UserException;
	
	public User userLogin(String username ,String pword) throws UserException;
}
