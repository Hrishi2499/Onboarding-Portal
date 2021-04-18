package com.training.msau.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper implements RowMapper<Skill>{
	
	@Override
	public Skill mapRow(ResultSet rs, int rowNum) throws SQLException{
			Skill sk = new Skill();
			sk.setSkill(rs.getString("skill"));
			sk.setSkillId(rs.getLong("skill_id"));
			return sk;
	}
}
