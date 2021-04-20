package com.training.msau.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper implements RowMapper<Skill>{
	
	@Override
	public Skill mapRow(ResultSet rs, int rowNum) throws SQLException{
		Skill skill = new Skill();
		skill.setSkillId((long)rs.getLong("skill_id"));
		skill.setSkill((String)rs.getString("skill"));
		
		return skill;
	}
}
