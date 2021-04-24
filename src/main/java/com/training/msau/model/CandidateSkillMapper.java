package com.training.msau.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CandidateSkillMapper implements RowMapper<CandidateSkill>{
	
	@Override
	 public CandidateSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
		CandidateSkill cs = new CandidateSkill();
		cs.setCandidateId((long)rs.getLong("candidate_id"));
		cs.setSkill(rs.getString("skill"));
		
		return cs;
	}
	

}
