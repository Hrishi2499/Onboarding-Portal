package com.training.msau.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class OnboardLogMapper implements RowMapper<OnboardLog>{

	@Override
	public OnboardLog mapRow(ResultSet rs, int rowNum) throws SQLException{
		OnboardLog onboardLog = new OnboardLog();
		
		onboardLog.setLogId(rs.getLong("log_id"));
		onboardLog.setAction(rs.getString("action"));
		onboardLog.setTimestamp(rs.getTimestamp("time_stamp"));
		onboardLog.setUser(rs.getString("user"));
		onboardLog.setUserEmail(rs.getString("user_email"));
		
		return onboardLog;
	}
}
