package com.training.msau.model;

import org.springframework.stereotype.Component;

@Component
public class Skill {

	private long skillId;
	private String skill;
	
	public long getSkillId() {
		return skillId;
	}
	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
}
