package com.training.msau.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestOnboardLog {

	@Autowired
	OnboardLog onboardLog;
	
	@Test
	public void testGetterSetterLogId() {
		long logId = 10;
		assertEquals(logId, onboardLog.setLogId(logId).getLogId());
	}
	
	@Test
	public void testGetterSetterTimestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		assertEquals(timestamp, onboardLog.setTimestamp(timestamp).getTimestamp());
	}
	
	@Test
	public void testGetterSetterUser() {
		String user = "Hrishi Shenai";
		assertEquals(user, onboardLog.setUser(user).getUser());
	}
	
	@Test
	public void testGetterSetterUserEmail() {
		String userEmail = "Hrishi@gmail.com";
		assertEquals(userEmail, onboardLog.setUserEmail(userEmail).getUserEmail());
	}
	
	@Test
	public void testGetterSetterAction() {
		String action = "Update";
		assertEquals(action, onboardLog.setAction(action).getAction());
	}
	
	@Test
	public void testGetterSetterOnboard() {
		Onboard onboard = new Onboard();
		assertEquals(onboard, onboardLog.setOnboard(onboard).getOnboard());
	}
}
