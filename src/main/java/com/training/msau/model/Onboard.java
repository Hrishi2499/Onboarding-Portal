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
	public Onboard setCandidate(Candidate candidate) {
		this.candidate = candidate;
		return this;
	}
	public long getOnboardId() {
		return onboardId;
	}
	public Onboard setOnboardId(long onboardId) {
		this.onboardId = onboardId;
		return this;
	}
	public long getCandidateId() {
		return candidateId;
	}
	public Onboard setCandidateId(long candidateId) {
		this.candidateId = candidateId;
		return this;
	}
	public long getHmId() {
		return hmId;
	}
	public Onboard setHmId(long hmId) {
		this.hmId = hmId;
		return this;
	}
	public String getOnboardStatus() {
		return onboardStatus;
	}
	public Onboard setOnboardStatus(String onboardStatus) {
		this.onboardStatus = onboardStatus;
		return this;
	}

	public Date getStartDate() {
		return startDate;
	}
	public Onboard setStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}
	public Date getEta() {
		return eta;
	}
	public Onboard setEta(Date eta) {
		this.eta = eta;
		return this;
	}
	public HiringManager getHiringManager() {
		return hiringManager;
	}
	public Onboard setHiringManager(HiringManager hiringManager) {
		this.hiringManager = hiringManager;
		return this;
	}
	public String getLocation() {
		return location;
	}
	public Onboard setLocation(String location) {
		this.location = location;
		return this;
	}
	public boolean isBgStatus() {
		return bgStatus;
	}
	public Onboard setBgStatus(boolean bgStatus) {
		this.bgStatus = bgStatus;
		return this;
	}
	public boolean isGraduation() {
		return graduation;
	}
	public Onboard setGraduation(boolean graduation) {
		this.graduation = graduation;
		return this;
	}
	public boolean isTraining() {
		return training;
	}
	public Onboard setTraining(boolean training) {
		this.training = training;
		return this;
	}
	public String getUser() {
		return user;
	}
	public Onboard setUser(String user) {
		this.user = user;
		return this;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public Onboard setUserEmail(String userEmail) {
		this.userEmail = userEmail;
		return this;
	}
	
}
