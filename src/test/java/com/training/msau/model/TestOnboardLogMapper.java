package com.training.msau.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestOnboardLogMapper {
	
	@Mock
	ResultSet rs;
	
	@Autowired
	OnboardLogMapper logMapper;
	
	@Test
	public void mapRow() throws SQLException{
		long logId = 42;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String user = "Hrishikesh Shenai";
		String userEmail = "sample@gmail.com";
		String action = "Update";
		
		Mockito.when(rs.getLong("log_id")).thenReturn(logId);
		Mockito.when(rs.getTimestamp("time_stamp")).thenReturn(timestamp);
		Mockito.when(rs.getString("user")).thenReturn(user);
		Mockito.when(rs.getString("user_email")).thenReturn(userEmail);
		Mockito.when(rs.getString("action")).thenReturn(action);
		
		OnboardLog onboardLog = logMapper.mapRow(rs, 0);
		
		assertNotNull(onboardLog);
		assertEquals(logId, onboardLog.getLogId());
		assertEquals(timestamp, onboardLog.getTimestamp());
		assertEquals(user, onboardLog.getUser());
		assertEquals(userEmail, onboardLog.getUserEmail());
		assertEquals(action, onboardLog.getAction());
		
	}

}
