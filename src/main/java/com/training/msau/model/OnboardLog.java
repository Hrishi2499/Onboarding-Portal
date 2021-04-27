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
	public void setLogId(long logId) {
		this.logId = logId;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Onboard getOnboard() {
		return onboard;
	}
	public void setOnboard(Onboard onboard) {
		this.onboard = onboard;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
