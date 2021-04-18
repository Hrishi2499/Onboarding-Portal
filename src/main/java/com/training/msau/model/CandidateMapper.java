package com.training.msau.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CandidateMapper implements RowMapper<Candidate>{
	
	@Override
	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException{
		Candidate can = new Candidate();
		can.setCandidateId((long)rs.getLong("candidate_id"));
		can.setCollege((String)rs.getString("college"));
		can.setEmail((String)rs.getString("email"));
		can.setFirstName((String)rs.getString("first_name"));
		can.setLastName((String)rs.getString("last_name"));
		
		return can;
	}
}
