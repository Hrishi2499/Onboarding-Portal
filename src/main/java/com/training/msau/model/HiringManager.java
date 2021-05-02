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
	public HiringManager setName(String name) {
		this.name = name;
		return this;
	}
	public long getHmId() {
		return hmId;
	}
	public HiringManager setHmId(long hmId) {
		this.hmId = hmId;
		return this;
	}
	public String getHm_email() {
		return hm_email;
	}
	public HiringManager setHm_email(String hm_email) {
		this.hm_email = hm_email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public HiringManager setPassword(String password) {
		this.password = password;
		return this;
	}
	
}
