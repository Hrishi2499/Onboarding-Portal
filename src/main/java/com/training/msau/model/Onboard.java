package com.training.msau.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Onboard {
	
	private long onboardId;
	private long candidateId;
	private long hmId;
	private String onboardStatus;
	private String location;
	private Date startDate;
	private Date eta;
	private boolean bgStatus;
	private boolean graduation;
	private boolean training;
	private String user;
	private String userEmail;
	
	private Candidate candidate;
	private HiringManager hiringManager;
	
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public long getOnboardId() {
		return onboardId;
	}
	public void setOnboardId(long onboardId) {
		this.onboardId = onboardId;
	}
	public long getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}
	public long getHmId() {
		return hmId;
	}
	public void setHmId(long hmId) {
		this.hmId = hmId;
	}
	public String getOnboardStatus() {
		return onboardStatus;
	}
	public void setOnboardStatus(String onboardStatus) {
		this.onboardStatus = onboardStatus;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEta() {
		return eta;
	}
	public void setEta(Date eta) {
		this.eta = eta;
	}
	public HiringManager getHiringManager() {
		return hiringManager;
	}
	public void setHiringManager(HiringManager hiringManager) {
		this.hiringManager = hiringManager;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isBgStatus() {
		return bgStatus;
	}
	public void setBgStatus(boolean bgStatus) {
		this.bgStatus = bgStatus;
	}
	public boolean isGraduation() {
		return graduation;
	}
	public void setGraduation(boolean graduation) {
		this.graduation = graduation;
	}
	public boolean isTraining() {
		return training;
	}
	public void setTraining(boolean training) {
		this.training = training;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}