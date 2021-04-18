package com.training.msau.model;

import org.springframework.stereotype.Component;

@Component
public class CandidateSkill {

	private long candidateId;
	private long skillId;
	
	public long getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}
	public long getSkillId() {
		return skillId;
	}
	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}
	
	
}
