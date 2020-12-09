package com.xyz.ecommerce.exception;

import java.util.Date;

public class ErrorDetails {
	
	private Date timeStamp;
	private String message;
	private String deatils;
	
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDeatils() {
		return deatils;
	}
	public void setDeatils(String deatils) {
		this.deatils = deatils;
	}
	public ErrorDetails(Date timeStamp, String message, String deatils) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.deatils = deatils;
	}
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
