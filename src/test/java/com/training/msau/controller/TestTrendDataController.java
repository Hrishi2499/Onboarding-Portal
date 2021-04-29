package com.training.msau.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.training.msau.model.TrendData;
import com.training.msau.repository.TrendDataDAO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = TrendDataController.class)
public class TestTrendDataController {

	@InjectMocks
    TrendDataController tdController;
     
    @MockBean
    TrendDataDAO tdDAO;
    
    @Autowired                           
    private MockMvc mockMvc;

	TrendData td;
	
	String baseURL = "http://localhost:8080/api/v1";
	
	@BeforeEach
	public void setup() {
		td = new TrendData();
		List<String> cols = new ArrayList<>();
		long[][] data = new long[5][5];
		cols.add("col1");
		cols.add("col2");
		td.setName("Trends");
		td.setColumns(cols);
		td.setYears(cols);
		td.setData(data);
	}
	
	@Test
	public void testGetTrendsBySkill() throws Exception{
    	when(tdDAO.getTrendBySkills()).thenReturn(td);
    	this.mockMvc.perform(get(baseURL + "/trends/skill"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.years.size()", is(2)))
    				.andExpect(jsonPath("$.columns.size()", is(2)))
    				.andExpect(jsonPath("$.name", is("Trends")));
	}
	
	@Test
	public void testGetTrendsByLocation() throws Exception{
    	when(tdDAO.getTrendByLocation()).thenReturn(td);
    	this.mockMvc.perform(get(baseURL + "/trends/location"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.years.size()", is(2)))
    				.andExpect(jsonPath("$.columns.size()", is(2)))
    				.andExpect(jsonPath("$.name", is("Trends")));
	}
	
	@Test
	public void testGetTrendsByManager() throws Exception{
    	when(tdDAO.getTrendByManager()).thenReturn(td);
    	this.mockMvc.perform(get(baseURL + "/trends/manager"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.years.size()", is(2)))
    				.andExpect(jsonPath("$.columns.size()", is(2)))
    				.andExpect(jsonPath("$.name", is("Trends")));
	}
}
