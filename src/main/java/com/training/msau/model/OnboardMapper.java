package com.training.msau.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class OnboardMapper implements RowMapper<Onboard>{
	
	@Override
	public Onboard mapRow(ResultSet rs, int rowNum) throws SQLException{
		Onboard op = new Onboard();
		
		op.setCandidateId((long)rs.getLong("candidate_id"));
		op.setEta((Date)rs.getDate("eta"));
		op.setHmId((long)rs.getLong("hm_id"));
		op.setOnboardId((long)rs.getLong("onboard_id"));
		op.setOnboardStatus((String)rs.getString("onboard_status"));
		op.setStartDate((Date)rs.getDate("start_date"));
		op.setLocation(rs.getString("location"));
		op.setBgStatus(rs.getBoolean("bg_status"));
		op.setTraining(rs.getBoolean("training"));
		op.setGraduation(rs.getBoolean("graduation"));
		op.setUser(rs.getString("user"));
		op.setUserEmail(rs.getString("user_email"));
		
		return op;
		
	}
}
