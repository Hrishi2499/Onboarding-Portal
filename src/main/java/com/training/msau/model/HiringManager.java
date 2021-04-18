package com.training.msau.model;

import org.springframework.stereotype.Component;

@Component
public class HiringManager {

	private long hmId;
	private String name;
	private String emailId;
	
	public long gethId() {
		return hmId;
	}
	public void sethId(long hId) {
		this.hmId = hId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
