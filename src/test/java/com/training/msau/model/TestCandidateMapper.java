package com.training.msau.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCandidateMapper {

	@Mock
	private ResultSet rs;
	
	@Autowired
	CandidateMapper candidateMapper;
	
	@Test
	public void testMapRow() throws SQLException{
		long candidateId = 1;
		String firstName = "Hrishi";
		String lastName = "Shenai";
		String email = "sample@gmail.com";
		String college = "DJ Sanghvi";
		boolean onboardStarted = true;
		String skill = "Java";
		
		Mockito.when(rs.getLong("candidate_id")).thenReturn(candidateId);
		Mockito.when(rs.getString("first_name")).thenReturn(firstName);
		Mockito.when(rs.getString("last_name")).thenReturn(lastName);
		Mockito.when(rs.getString("email")).thenReturn(email);
		Mockito.when(rs.getString("college")).thenReturn(college);
		Mockito.when(rs.getString("skill")).thenReturn(skill);
		Mockito.when(rs.getBoolean("onboard_started")).thenReturn(onboardStarted);
		
		Candidate candidate = candidateMapper.mapRow(rs, 0);
		
		assertNotNull(candidate);
		assertEquals(candidateId, candidate.getCandidateId());
		assertEquals(firstName, candidate.getFirstName());
		assertEquals(lastName, candidate.getLastName());
		assertEquals(email, candidate.getEmail());
		assertEquals(college, candidate.getCollege());
		assertEquals(onboardStarted, candidate.isOnboardStarted());
		assertEquals(skill, candidate.getSkill());
	}
}
