package com.training.msau.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class OnboardProcessMapper implements RowMapper<OnboardProcess>{
	
	@Override
	public OnboardProcess mapRow(ResultSet rs, int rowNum) throws SQLException{
		OnboardProcess op = new OnboardProcess();
		op.setBgStatus(rs.getString("bg_status"));
		op.setCandidateId(rs.getLong("candidate_id"));
		op.setEta(rs.getDate("eta"));
		op.setHmId(rs.getLong("hm_id"));
		op.setOnboardId(rs.getLong("onboard_id"));
		op.setOnboardStatus(rs.getString("onboard_status"));
		op.setStartDate(rs.getDate("start_date"));
		
		return op;
		
	}
}
