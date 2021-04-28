package com.training.msau.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestOnboardMapper {
	
	@Mock
	ResultSet rs;
	
	@Autowired
	OnboardMapper onboardMapper;
	
	@Test
	public void testMapRow() throws SQLException{
		
		long onboardId = 42;
		long candidateId = 1;
		long hmId = 101;
		String onboardStatus = "Completed";
		String location = "Mumbai";
		Date startDate = Date.valueOf("2021-04-27");
		Date eta = Date.valueOf("2021-04-27");
		boolean bgStatus = true;
		boolean graduation= false;
		boolean training = true;
		String user = "Hrishi";
		String userEmail = "sample@gmail.com";
		
		Mockito.when(rs.getLong("onboard_id")).thenReturn(onboardId);
		Mockito.when(rs.getLong("candidate_id")).thenReturn(candidateId);
		Mockito.when(rs.getLong("hm_id")).thenReturn(hmId);
		Mockito.when(rs.getString("onboard_status")).thenReturn(onboardStatus);
		Mockito.when(rs.getString("location")).thenReturn(location);
		Mockito.when(rs.getDate("start_date")).thenReturn(startDate);
		Mockito.when(rs.getDate("eta")).thenReturn(eta);
		Mockito.when(rs.getBoolean("bg_status")).thenReturn(bgStatus);
		Mockito.when(rs.getBoolean("training")).thenReturn(training);
		Mockito.when(rs.getBoolean("graduation")).thenReturn(graduation);
		Mockito.when(rs.getString("user")).thenReturn(user);
		Mockito.when(rs.getString("user_email")).thenReturn(userEmail);
		
		Onboard onboard = onboardMapper.mapRow(rs, 0);
		
		
		assertNotNull(onboard);
		assertEquals(onboardId, onboard.getOnboardId());
		assertEquals(candidateId, onboard.getCandidateId());
		assertEquals(hmId, onboard.getHmId());
		assertEquals(onboardStatus, onboard.getOnboardStatus());
		assertEquals(location, onboard.getLocation());
		assertEquals(startDate, onboard.getStartDate());
		assertEquals(eta, onboard.getEta());
		assertEquals(bgStatus, onboard.isBgStatus());
		assertEquals(training, onboard.isTraining());
		assertEquals(graduation, onboard.isGraduation());
		assertEquals(user, onboard.getUser());
		assertEquals(userEmail, onboard.getUserEmail());
	}

}
