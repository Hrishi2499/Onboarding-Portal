package com.training.msau.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.training.msau.model.Onboard;
import com.training.msau.model.OnboardLog;

@SpringBootTest
public class TestOnboardLogDAO {
	
	@Autowired
	OnboardLogDAO onboardLogDAO;
	
	@Test
	public void testSelectAllLogs(){
		assertEquals(28, onboardLogDAO.selectAllLogs().size());
	}
	
	@Test
	public void testLogsbyCandidateId(){
		List<OnboardLog> onboardLogs = onboardLogDAO.selectLogByCandidateId(1);
		assertEquals(10, onboardLogs.size());
		for(OnboardLog ol: onboardLogs) {
			assertEquals(1, ol.getOnboard().getCandidateId());
		}
	}
	
	@Test
	public void testLogsbyOnboardId(){
		List<OnboardLog> onboardLogs = onboardLogDAO.selectLogByOnboardId(47);
		assertEquals(3, onboardLogs.size());
		for(OnboardLog ol: onboardLogs) {
			assertEquals(47, ol.getOnboard().getOnboardId());
		}
	}
	
	@Test
	public void testLogsbyUser(){
		List<OnboardLog> onboardLogs = onboardLogDAO.selectLogByUser("Phantom");
		assertEquals(11, onboardLogs.size());
		for(OnboardLog ol: onboardLogs) {
			assertTrue(ol.getUser().contains("Phantom"));
		}
	}
	
	@Test
	public void testLogsbyYear(){
		List<OnboardLog> onboardLogs = onboardLogDAO.selectLogByYear("2021");
		assertEquals(28, onboardLogs.size());
		for(OnboardLog ol: onboardLogs) {
			assertEquals(ol.getTimestamp().toString().split("-")[0], "2021");
		}
	}
	
	@Test
	public void testLogsbyMonth(){
		List<OnboardLog> onboardLogs = onboardLogDAO.selectLogByMonth("04", "2021");
		assertEquals(28, onboardLogs.size());
		for(OnboardLog ol: onboardLogs) {
			assertEquals(ol.getTimestamp().toString().split("-")[0], "2021");
			assertEquals(ol.getTimestamp().toString().split("-")[1], "04");
		}
	}
	
	@Test
	public void testLogsbyDate(){
		List<OnboardLog> onboardLogs = onboardLogDAO.selectLogByDate("2021-04-28");
		assertEquals(12, onboardLogs.size());
		for(OnboardLog ol: onboardLogs) {
			assertEquals(ol.getTimestamp().toString().split("\\s")[0], "2021-04-28");
		}
	}
	
	@Transactional
	@Test
	public void testAddOnboardLog(){
		Onboard o = new Onboard();
		o.setOnboardId(56);
		o.setCandidateId(1);
		o.setHmId(101);
		OnboardLog onboardLog = new OnboardLog();
		onboardLog.setOnboard(o);
		int result = onboardLogDAO.addOnboardLog(onboardLog);
		assertEquals(1, result);
		OnboardLog newOnboardLog = onboardLogDAO.selectOnboardLogbyOneField("candidateId", new Object[] {1}).get(0);
		assertEquals(newOnboardLog.getOnboard().getCandidateId(), onboardLog.getOnboard().getCandidateId());
		assertEquals(newOnboardLog.getOnboard().getOnboardId(), onboardLog.getOnboard().getOnboardId());
		assertEquals(newOnboardLog.getOnboard().getHmId(), onboardLog.getOnboard().getHmId());
		
		//Test for Exception
		o.setCandidateId(100);
		OnboardLog onboardLogExp = new OnboardLog();
		onboardLogExp.setOnboard(o);
		assertThrows(DataIntegrityViolationException.class, ()->{onboardLogDAO.addOnboardLog(onboardLogExp);});
	}

}
