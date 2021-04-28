package com.training.msau.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCandidate {
	
	@Autowired
	Candidate candidate;
	
	@Test
	public void testGetterSetterId() {
		long candidateId = 10;
		assertEquals(candidateId, candidate.setCandidateId(candidateId).getCandidateId());
	}
	
	@Test
	public void testGetterSetterFirstName() {
		String firstName = "Hrishikesh";
		assertEquals(firstName, candidate.setFirstName(firstName).getFirstName());
	}
	
	@Test
	public void testGetterSetterLastName() {
		String lastName = "Shenai";
		assertEquals(lastName, candidate.setLastName(lastName).getLastName());
	}
	
	@Test
	public void testGetterSetterEmail() {
		String email = "sample@gmail.com";
		assertEquals(email, candidate.setEmail(email).getEmail());
	}
	
	@Test
	public void testSetterGetterCollege() {
		String college = "DJ Sanghvi";
		assertEquals(college, candidate.setCollege(college).getCollege());
	}
	
	@Test
	public void testGetterSetterOnboardStatus() {
		boolean onboardStatus = true;
		assertEquals(onboardStatus, candidate.setOnboardStarted(onboardStatus).isOnboardStarted());
	}
	
	@Test
	public void testGetterSetterSkill() {
		String skill = "Java";
		assertEquals(skill, candidate.setSkill(skill).getSkill());
	}
	
}
