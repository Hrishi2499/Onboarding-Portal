package com.training.msau.model;

import org.springframework.stereotype.Component;

@Component
public class HiringManager {

	private long hmId;
	private String name;
	private String hm_email;
	
	public long gethId() {
		return hmId;
	}
	public void sethId(long hmId) {
		this.hmId = hmId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String gethmEmail() {
		return hm_email;
	}
	public void sethmEmail(String email) {
		this.hm_email = email;
	}
	
	
}
