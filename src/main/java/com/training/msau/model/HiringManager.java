package com.training.msau.model;

import org.springframework.stereotype.Component;

@Component
public class HiringManager {

	private long hmId;
	private String name;
	private String hm_email;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getHmId() {
		return hmId;
	}
	public void setHmId(long hmId) {
		this.hmId = hmId;
	}
	public String getHm_email() {
		return hm_email;
	}
	public void setHm_email(String hm_email) {
		this.hm_email = hm_email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
