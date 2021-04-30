package com.training.msau.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.training.msau.model.Onboard;
import com.training.msau.model.OnboardLog;
import com.training.msau.repository.OnboardLogDAO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = OnboardLogController.class)
public class TestOnboardLogController {

	@InjectMocks
    OnboardLogController olController;
     
    @MockBean
    OnboardLogDAO olDAO;
    
    @Autowired                           
    private MockMvc mockMvc;

	List<OnboardLog> list;
	
	String baseURL = "http://localhost:8080/api/v1";
	
	@BeforeEach
	public void setup() {
		list = new ArrayList<>();
		OnboardLog ol = new OnboardLog();
		Onboard o = new Onboard();
		ol.setLogId(101);
		o.setOnboardId(42);
		o.setCandidateId(1);
		ol.setOnboard(o);
		ol.setUser("Hrishi");
		ol.setTimestamp(new Timestamp(System.currentTimeMillis()));
		list.add(ol);
		
		ol = new OnboardLog();
		o = new Onboard();
		ol.setLogId(102);
		o.setOnboardId(42);
		o.setCandidateId(1);
		ol.setOnboard(o);
		ol.setUser("Hrishi");
		ol.setTimestamp(new Timestamp(System.currentTimeMillis()));
		list.add(ol);
	}
	@Test
	public void testGetAllLogs() throws Exception{
    	when(olDAO.selectAllLogs()).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboardLogs"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(2)));
	}
	
	@Test
	public void testGetLogsByCandidateId() throws Exception{
    	when(olDAO.selectLogByCandidateId(1)).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboardLogs/candidateId=1"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(2)))
    				.andExpect(jsonPath("$[0].onboard.candidateId", is(1)))
    				.andExpect(jsonPath("$[1].onboard.candidateId", is(1)));
	}
	
	@Test
	public void testGetLogsByOnboardId() throws Exception{
    	when(olDAO.selectLogByOnboardId(42)).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboardLogs/onboardId=42"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(2)))
    				.andExpect(jsonPath("$[0].onboard.onboardId", is(42)))
    				.andExpect(jsonPath("$[1].onboard.onboardId", is(42)));
	}
	
	@Test
	public void testGetLogsByUser() throws Exception{
    	when(olDAO.selectLogByUser("Hrishi")).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboardLogs/user=Hrishi"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(2)))
    				.andExpect(jsonPath("$[0].user", is("Hrishi")))
    				.andExpect(jsonPath("$[1].user", is("Hrishi")));
	}
	
	@Test
	public void testGetLogsByYear() throws Exception{
    	when(olDAO.selectLogByYear("2021")).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboardLogs/year=2021"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(2)))
    				.andExpect(jsonPath("$[0].timestamp", stringContainsInOrder("2021")))
    				.andExpect(jsonPath("$[1].timestamp", stringContainsInOrder("2021")));
	}
	
	@Test
	public void testGetLogsByMonth() throws Exception{
    	when(olDAO.selectLogByMonth("04","2021")).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboardLogs/month=2021-04"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(2)))
    				.andExpect(jsonPath("$[0].timestamp", stringContainsInOrder("2021-04")))
    				.andExpect(jsonPath("$[1].timestamp", stringContainsInOrder("2021-04")));
	}
	
	@Test
	public void testGetLogsByDate() throws Exception{
    	when(olDAO.selectLogByDate("2021-04-29")).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboardLogs/date=2021-04-29"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(2)))
    				.andExpect(jsonPath("$[0].timestamp", stringContainsInOrder("2021-04-30")))
    				.andExpect(jsonPath("$[1].timestamp", stringContainsInOrder("2021-04-30")));
	}
	
	@Test
	public void testAddOnboard() throws Exception{
		when(olDAO.addOnboardLog(Mockito.any(OnboardLog.class))).thenReturn(1);
		JsonMapper jm = new JsonMapper();
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put(baseURL + "/onboardLogs")
				.accept(MediaType.APPLICATION_JSON).content(jm.writeValueAsBytes(list.get(0)))
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
}
