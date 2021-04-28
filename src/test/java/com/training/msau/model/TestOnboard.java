package com.training.msau.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestOnboard {
	
	@Autowired
	Onboard onboard;
	
	@Test
	public void testGetterSetterOnboardId() {
		long onboardId = 42;
		assertEquals(onboardId, onboard.setOnboardId(onboardId).getOnboardId());
	}
	
	@Test
	public void testGetterSetterCandidateId() {
		long candidateId = 42;
		assertEquals(candidateId, onboard.setCandidateId(candidateId).getCandidateId());
	}
	
	@Test
	public void testGetterSetterHmId() {
		long hmId = 42;
		assertEquals(hmId, onboard.setHmId(hmId).getHmId());
	}
	
	@Test
	public void testGetterSetterOnboardStatus() {
		String status = "Started";
		assertEquals(status, onboard.setOnboardStatus(status).getOnboardStatus());
	}
	
	@Test
	public void testGetterSetterLocation() {
		String location = "Mumbai";
		assertEquals(location, onboard.setLocation(location).getLocation());
	}
	
	@Test
	public void testGetterSetterStartDate() {
		Date start = Date.valueOf("2021-04-27");
		assertEquals(start, onboard.setStartDate(start).getStartDate());
	}
	
	@Test
	public void testGetterSetterEta() {
		Date eta = Date.valueOf("2021-04-27");
		assertEquals(eta, onboard.setEta(eta).getEta());
	}
	
	@Test
	public void testGetterSetterBgStatus() {
		boolean bgStatus = true;
		assertEquals(bgStatus, onboard.setBgStatus(bgStatus).isBgStatus());
	}
	
	@Test
	public void testGetterSetterGraduation() {
		boolean graduation = true;
		assertEquals(graduation, onboard.setGraduation(graduation).isGraduation());
	}
	
	@Test
	public void testGetterSetterTraining() {
		boolean training = true;
		assertEquals(training, onboard.setTraining(training).isTraining());
	}
	
	@Test
	public void testGetterSetterUser() {
		String user = "Hrishi";
		assertEquals(user, onboard.setUser(user).getUser());
	}
	
	@Test
	public void testGetterSetterUserEmail() {
		String email = "Hrishi@gmail.com";
		assertEquals(email, onboard.setUserEmail(email).getUserEmail());
	}
	
	@Test
	public void testGetterSetterHiringManager() {
		HiringManager hm = new HiringManager();
		assertEquals(hm, onboard.setHiringManager(hm).getHiringManager());
	}
	
	@Test
	public void testGetterSetterCandidate() {
		Candidate candidate = new Candidate();
		assertEquals(candidate, onboard.setCandidate(candidate).getCandidate());
	}

}
