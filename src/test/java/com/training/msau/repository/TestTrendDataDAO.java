package com.training.msau.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.msau.model.TrendData;

@SpringBootTest
public class TestTrendDataDAO {

	@Autowired
	TrendDataDAO trendDataDAO;
	
	@Test
	public void testGetYearCount() {
		assertEquals(2, trendDataDAO.getYearCount());
	}
	
	@Test
	public void testGetLocationCount() {
		assertEquals(3, trendDataDAO.getLocationCount());
	}
	
	@Test
	public void testGetHmIdCount() {
		assertEquals(2, trendDataDAO.getHmIdCount());
	}
	
	@Test
	public void testGetSkillCount() {
		assertEquals(3, trendDataDAO.getSkillCount());
	}
	
	@Test
	public void testGetTrendByLocation() {
		TrendData trend = trendDataDAO.getTrendByLocation();
		assertNotNull(trend);
		assertEquals(3, trend.getColumns().size());
	}
	
	@Test
	public void testGetTrendByManager() {
		TrendData trend = trendDataDAO.getTrendByManager();
		assertNotNull(trend);
		assertEquals(2, trend.getColumns().size());
	}
	
	@Test
	public void testGetTrendBySkills() {
		TrendData trend = trendDataDAO.getTrendBySkills();
		assertNotNull(trend);
		assertEquals(3, trend.getColumns().size());
	}
}
