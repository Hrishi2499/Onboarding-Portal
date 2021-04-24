package com.training.msau.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CandidateMapper implements RowMapper<Candidate>{
	
	@Override
	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		Candidate candidate = new Candidate();
		candidate.setCandidateId((long)rs.getLong("candidate_id"));
		candidate.setCollege((String)rs.getString("college"));
		candidate.setEmail((String)rs.getString("email"));
		candidate.setFirstName((String)rs.getString("first_name"));
		candidate.setLastName((String)rs.getString("last_name"));
		candidate.setOnboardStarted(rs.getBoolean("onboard_started"));
		
		return candidate;
	}
}
