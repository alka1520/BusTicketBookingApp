package com.model;

public class User {
	
//	private int pid;
	private String pname;
	private String email;
	private String pword;
//	public int getPid() {
//		return pid;
//	}
//	public void setPid(int pid) {
//		this.pid = pid;
//	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	public User( String pname, String email, String pword) {
		super();
//		this.pid = pid;
		this.pname = pname;
		this.email = email;
		this.pword = pword;
	}
	@Override
	public String toString() {
		return "User [ pname=" + pname + ", email=" + email + ", pword=" + pword + "]";
	}
	
	
}
