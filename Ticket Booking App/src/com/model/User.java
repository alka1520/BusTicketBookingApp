package com.model;

public class User {

	private String name;
	private int userid;
	private String username;
	private String password;
	private String contact;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public User(int userid, String username, String contact) {
		super();
		this.userid = userid;
		this.username = username;
		this.contact = contact;
	}
	public User(String name, String username, String password, String contact) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "User Detail \n name=" + name + ", username=" + username + ", contact=" + contact + "]";
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	
	
}
