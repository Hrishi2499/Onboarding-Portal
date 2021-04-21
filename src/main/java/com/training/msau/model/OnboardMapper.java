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
		op.setBgStatus((String)rs.getString("bg_status"));
		op.setCandidateId((long)rs.getLong("candidate_id"));
		op.setEta((Date)rs.getDate("eta"));
		op.setHmId((long)rs.getLong("hm_id"));
		op.setOnboardId((long)rs.getLong("onboard_id"));
		op.setOnboardStatus((String)rs.getString("onboard_status"));
		op.setStartDate((Date)rs.getDate("start_date"));
		
		return op;
		
	}
}
