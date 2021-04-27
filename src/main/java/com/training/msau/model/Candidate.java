package com.training.msau.model;

import org.springframework.stereotype.Component;

@Component
public class Candidate {

	private long candidateId;
	private String firstName;
	private String lastName;
	private String email;
	private String college;
	private boolean onboardStarted;
	private String skill;
	
	public long getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public boolean isOnboardStarted() {
		return onboardStarted;
	}
	public void setOnboardStarted(boolean onboardStarted) {
		this.onboardStarted = onboardStarted;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}

	
	
	
}
