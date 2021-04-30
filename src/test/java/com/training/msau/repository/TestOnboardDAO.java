package com.training.msau.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.training.msau.exception.InsertionException;
import com.training.msau.model.Onboard;

@SpringBootTest
public class TestOnboardDAO {

	@Autowired
	OnboardDAO onboardDAO;
	
	@Test
	public void testSelectAll(){
		assertEquals(7, onboardDAO.selectAllOnboards().size());
	}
	
	@Test
	public void testSelectOnboardbyCandidateId(){
		Onboard onboard = onboardDAO.selectOnboardByCandidateId(6).get(0); 
		assertNotNull(onboard);
		assertEquals(6, onboard.getCandidateId());
		assertEquals(48, onboard.getOnboardId());
	}
	
	@Test
	public void testSelectOnboardbyOnboardId(){
		Onboard onboard = onboardDAO.selectOnboardByOnboardId(48).get(0); 
		assertNotNull(onboard);
		assertEquals(48, onboard.getOnboardId());
		assertEquals(6, onboard.getCandidateId());
	}
	
	@Test
	public void testSelectOnboardbyHmId(){
		List<Onboard> onboards = onboardDAO.selectOnboardByHmId(101); 
		assertNotNull(onboards);
		assertEquals(2, onboards.size());
		for(Onboard o: onboards) {
			assertEquals(101, o.getHmId());
		}
	}
	
	@Test
	public void testSelectOnboardbyLocation(){
		List<Onboard> onboards = onboardDAO.selectOnboardByLocation("Bangalore"); 
		assertNotNull(onboards);
		assertEquals(2, onboards.size());
		for(Onboard o: onboards) {
			assertEquals("Bangalore", o.getLocation());
		}
	}
	
	@Test
	public void testSelectOnboardbySkill(){
		List<Onboard> onboards = onboardDAO.selectOnboardBySkill("Java"); 
		assertNotNull(onboards);
		assertEquals(1, onboards.size());
		for(Onboard o: onboards) {
			assertEquals("Java", o.getCandidate().getSkill());
		}
	}
	
	@Test
	public void testSelectOnboardbyFirstName(){
		List<Onboard> onboards = onboardDAO.selectOnboardByFirstName("Hrishi"); 
		assertNotNull(onboards);
		assertEquals(2, onboards.size());
		for(Onboard o: onboards) {
			assertTrue(o.getCandidate().getFirstName().contains("Hrishi"));
		}
	}
	
	@Test
	public void testSelectOnboardbyLastName(){
		List<Onboard> onboards = onboardDAO.selectOnboardByLastName("Shenai"); 
		assertNotNull(onboards);
		assertEquals(1, onboards.size());
		for(Onboard o: onboards) {
			assertTrue(o.getCandidate().getLastName().contains("Shenai"));
		}
	}
	
	@Test
	public void testSelectOnboardbyCollege(){
		List<Onboard> onboards = onboardDAO.selectOnboardByCollege("DJ"); 
		assertNotNull(onboards);
		assertEquals(2, onboards.size());
		for(Onboard o: onboards) {
			assertTrue(o.getCandidate().getCollege().contains("DJ"));
		}
	}
	
	@Test
	public void testSelectOnboardbyManager(){
		List<Onboard> onboards = onboardDAO.selectOnboardByManagerName("Manager"); 
		assertNotNull(onboards);
		assertEquals(7, onboards.size());
		for(Onboard o: onboards) {
			assertTrue(o.getHiringManager().getName().contains("Manager"));
		}
	}
	
	@Test
	public void testSelectOnboardbyOnboardStatus(){
		List<Onboard> onboards = onboardDAO.selectOnboardByOnboardStatus("Completed"); 
		assertNotNull(onboards);
		assertEquals(4, onboards.size());
		for(Onboard o: onboards) {
			assertTrue(o.getOnboardStatus().contains("Completed"));
		}
	}
	
	@Transactional
	@Test
	public void testAddOnboard(){
		Onboard onboard = new Onboard();
		onboard.setCandidateId(4);
		onboard.setHmId(101);
		onboard = onboardDAO.addOnboard(onboard).get(0);
		assertNotNull(onboard);
		Onboard newOnboard = onboardDAO.selectOnboardbyOneField("candidateId", new Object[] {4}).get(0);
		assertEquals(newOnboard.getCandidateId(), onboard.getCandidateId());
		assertEquals(newOnboard.getOnboardId(), onboard.getOnboardId());
		assertEquals(newOnboard.getHmId(), onboard.getHmId());
		
		//Test for Exception
		Onboard onboardExp = new Onboard();
		onboardExp.setCandidateId(1);
		onboardExp.setHmId(101);
		assertThrows(InsertionException.class, ()->{onboardDAO.addOnboard(onboardExp);});
	}
	
	
	@Transactional
	@Test
	public void testUpdateOnboard(){
		Onboard onboard = onboardDAO.selectOnboardbyOneField("onboardId", new Object[] {48}).get(0);
		onboard.setBgStatus(false);
		onboard.setTraining(false);
		onboard.setUser("Hrishikesh Shenai");
		Onboard updated = onboardDAO.updateOnboard(onboard).get(0);
		assertNotNull(updated);
		assertEquals(onboard.isBgStatus(), updated.isBgStatus());
		assertEquals(onboard.isTraining(), updated.isTraining());
		assertEquals(onboard.getUser(), updated.getUser());
	}
	
	@Transactional
	@Test
	public void testDeleteOnboard(){
		long onboardId = 100;
		assertNull(onboardDAO.deleteOnboard(onboardId, null, null));
	}
	
}
