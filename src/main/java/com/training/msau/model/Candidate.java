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
	public Candidate setCandidateId(long candidateId) {
		this.candidateId = candidateId;
		return this;
	}
	public String getFirstName() {
		return firstName;
	}
	public Candidate setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public Candidate setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Candidate setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getCollege() {
		return college;
	}
	public Candidate setCollege(String college) {
		this.college = college;
		return this;
	}
	public boolean isOnboardStarted() {
		return onboardStarted;
	}
	public Candidate setOnboardStarted(boolean onboardStarted) {
		this.onboardStarted = onboardStarted;
		return this;
	}
	public String getSkill() {
		return skill;
	}
	public Candidate setSkill(String skill) {
		this.skill = skill;
		return this;
	}
	
}
