package com.training.msau.model;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class OnboardLog {
	private long logId;
	private Timestamp timestamp;
	private String user;
	private String userEmail;
	private String action;
	
	private Onboard onboard;
	
	public long getLogId() {
		return logId;
	}
	public OnboardLog setLogId(long logId) {
		this.logId = logId;
		return this;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public OnboardLog setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	public String getUser() {
		return user;
	}
	public OnboardLog setUser(String user) {
		this.user = user;
		return this;
	}
	public String getAction() {
		return action;
	}
	public OnboardLog setAction(String action) {
		this.action = action;
		return this;
	}
	public Onboard getOnboard() {
		return onboard;
	}
	public OnboardLog setOnboard(Onboard onboard) {
		this.onboard = onboard;
		return this;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public OnboardLog setUserEmail(String userEmail) {
		this.userEmail = userEmail;
		return this;
	}
	
}
