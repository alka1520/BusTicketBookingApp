package com.model;

public class Admin {
	
	private String name;
	private String uname;
	private String password;
	private String email;
	private String contact;
	
	public Admin() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Admin [name=" + name + ", uname=" + uname + ", password=" + password + ", email=" + email + ", contact="
				+ contact + "]";
	}
	public Admin(String name, String uname, String password, String email, String contact) {
		super();
		this.name = name;
		this.uname = uname;
		this.password = password;
		this.email = email;
		this.contact = contact;
	}
	
	
}
