package com.training.msau.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestTrendData {
	
	@Autowired
	TrendData trendData;
	
	@Test
	public void testGetterSetterName() {
		String name = "Skill trends";
		assertEquals(name, trendData.setName(name).getName());
	}
	
	@Test
	public void testGetterSetterColumns() {
		List<String> col = new ArrayList<>();
		assertEquals(col, trendData.setColumns(col).getColumns());
	}
	
	@Test
	public void testGetterSetterYears() {
		List<String> year = new ArrayList<>();
		assertEquals(year, trendData.setYears(year).getYears());
	}
	
	@Test
	public void testGetterSetterData() {
		long[][] data = new long[5][5];
		assertEquals(data, trendData.setData(data).getData());
	}

}
