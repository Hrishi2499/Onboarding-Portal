package com.training.msau.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.msau.model.Candidate;

@SpringBootTest
public class TestCandidateDAO {
	
	@Autowired
	CandidateDAO candidateDAO;
	
	@Test
	public void testSelectAllCandidate(){
		assertEquals(10, candidateDAO.selectAllCandidate().size());
	}
	
	@Test
	public void testSelectById() {
		assertEquals(1, candidateDAO.selectById(1).get(0).getCandidateId());
	}
	
	@Test
	public void testSelectByFirstName() {
		String name = "Hrishi";
		List<Candidate> candidates = candidateDAO.selectByFirstName("%" + name +"%");
		assertEquals(2, candidates.size());
		for(Candidate c: candidates) {
			assertTrue(c.getFirstName().contains(name));
		}
	}
	
	@Test
	public void testSelectByLastName() {
		String name = "Shenai";
		List<Candidate> candidates = candidateDAO.selectByLastName("%" + name +"%");
		assertEquals(1, candidates.size());
		for(Candidate c: candidates) {
			assertTrue(c.getLastName().contains(name));
		}
	}
	
	@Test
	public void testSelectByCollege() {
		String college = "SP";
		List<Candidate> candidates = candidateDAO.selectByCollege("%"+college+"%");
		assertEquals(6, candidates.size());
		for(Candidate c: candidates) {
			assertTrue(c.getCollege().contains(college));
		}
	}
	
	@Test
	public void testSelectBySkill() {
		String skill = "Java";
		List<Candidate> candidates = candidateDAO.selectBySkill("%"+skill+"%"); 
		assertEquals(4, candidates.size());
		for(Candidate c: candidates) {
			assertEquals(skill, c.getSkill());
		}
	}
	

}
