package com.supreet.springsecurity.entity;


public class AuthRequest {
	public AuthRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public AuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AuthRequest [userName=" + userName + ", password=" + password + "]";
	}
}
