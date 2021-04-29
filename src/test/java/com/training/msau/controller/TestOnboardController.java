package com.training.msau.controller;

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
import com.training.msau.model.Candidate;
import com.training.msau.model.Onboard;
import com.training.msau.repository.OnboardDAO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = OnboardController.class)
public class TestOnboardController {
	@InjectMocks
    OnboardController onboardController;
     
    @MockBean
    OnboardDAO onboardDAO;
    
    @Autowired                           
    private MockMvc mockMvc;

	List<Onboard> list;
	
	String baseURL = "http://localhost:8080/api/v1";
	
	@BeforeEach
	public void setup() {
		list = new ArrayList<>();
		Onboard o = new Onboard();
		Candidate c = new Candidate();
		c.setCandidateId(1);
		c.setCollege("DJ");
		c.setFirstName("Hrishi");
		c.setLastName("Shenai");
		c.setSkill("Java");
		o.setCandidate(c);
		o.setCandidateId(1);
		o.setOnboardId(42);
		o.setHmId(101);
		o.setLocation("Mumbai");
		o.setOnboardStatus("Completed");
		list.add(o);
	}
	
	@Test
	public void testGetAllOnboards() throws Exception{
    	when(onboardDAO.selectAllOnboards()).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboards"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(1)));
	}
	
	@Test
	public void testGetOnboardbyCandidateId() throws Exception{
    	when(onboardDAO.selectOnboardByCandidateId(1)).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboards/candidateId=1"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(1)))
    				.andExpect(jsonPath("$[0].candidateId", is(1)));
	}
	
	@Test
	public void testGetOnboardbyOnboardId() throws Exception{
    	when(onboardDAO.selectOnboardByOnboardId(42)).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboards/onboardId=42"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(1)))
    				.andExpect(jsonPath("$[0].onboardId", is(42)));
	}
	
	@Test
	public void testGetOnboardbyHmId() throws Exception{
    	when(onboardDAO.selectOnboardByHmId(101)).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboards/hmId=101"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(1)))
    				.andExpect(jsonPath("$[0].hmId", is(101)));
	}
	
	@Test
	public void testGetOnboardbyFirstName() throws Exception{
    	when(onboardDAO.selectOnboardByFirstName("Hrishi")).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboards/firstName=Hrishi"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(1)))
    				.andExpect(jsonPath("$[0].onboardId", is(42)))
    				.andExpect(jsonPath("$[0].candidate.firstName", is("Hrishi")));
	}
	
	@Test
	public void testGetOnboardbyLastName() throws Exception{
    	when(onboardDAO.selectOnboardByLastName("Shenai")).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboards/lastName=Shenai"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(1)))
    				.andExpect(jsonPath("$[0].onboardId", is(42)))
    				.andExpect(jsonPath("$[0].candidate.lastName", is("Shenai")));
	}
	
	@Test
	public void testGetOnboardbyLocation() throws Exception{
    	when(onboardDAO.selectOnboardByLocation("Mumbai")).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboards/location=Mumbai"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(1)))
    				.andExpect(jsonPath("$[0].onboardId", is(42)))
    				.andExpect(jsonPath("$[0].location", is("Mumbai")));
	}
	
	@Test
	public void testGetOnboardbyCollege() throws Exception{
    	when(onboardDAO.selectOnboardByCollege("DJ")).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboards/college=DJ"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(1)))
    				.andExpect(jsonPath("$[0].onboardId", is(42)))
    				.andExpect(jsonPath("$[0].candidate.college", is("DJ")));
	}
	
	@Test
	public void testGetOnboardbySkill() throws Exception{
    	when(onboardDAO.selectOnboardBySkill("Java")).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboards/skill=Java"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(1)))
    				.andExpect(jsonPath("$[0].onboardId", is(42)))
    				.andExpect(jsonPath("$[0].candidate.skill", is("Java")));
	}
	
	@Test
	public void testGetOnboardbyOnboardStatus() throws Exception{
    	when(onboardDAO.selectOnboardByOnboardStatus("Completed")).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/onboards/onboardStatus=Completed"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(1)))
    				.andExpect(jsonPath("$[0].onboardId", is(42)))
    				.andExpect(jsonPath("$[0].onboardStatus", is("Completed")));
	}
	
	@Test
	public void testAddOnboard() throws Exception{
		when(onboardDAO.addOnboard(Mockito.any(Onboard.class))).thenReturn(list);
		JsonMapper jm = new JsonMapper();
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put(baseURL + "/onboards")
				.accept(MediaType.APPLICATION_JSON).content(jm.writeValueAsBytes(list.get(0)))
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void testDeleteOnboard() throws Exception{
		when(onboardDAO.deleteOnboard(Mockito.any(Long.class), Mockito.any(String.class), Mockito.any(String.class))).thenReturn(list);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete(baseURL + "/onboards/onboardId=10&user=Hrishi&userEmail=Sample")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void testUpdateOnboard() throws Exception{
		when(onboardDAO.updateOnboard(Mockito.any(Onboard.class))).thenReturn(list);
		JsonMapper jm = new JsonMapper();
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(baseURL + "/onboards")
				.accept(MediaType.APPLICATION_JSON).content(jm.writeValueAsBytes(list.get(0)))
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
}
