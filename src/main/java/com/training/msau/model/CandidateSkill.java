package com.training.msau.model;

import org.springframework.stereotype.Component;

@Component
public class CandidateSkill {

	private long candidateId;
	private String skill;
	
	public long getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
}
