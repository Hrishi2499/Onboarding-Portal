package com.training.msau.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import com.training.msau.model.Candidate;
import com.training.msau.repository.CandidateDAO;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CandidateController.class)
public class TestCandidateController {

	@InjectMocks
    CandidateController candidateController;
     
    @MockBean
    CandidateDAO candidateDAO;
    
    @Autowired                           
    private MockMvc mockMvc;

	List<Candidate> list;
	List<Candidate> singleResponse;
	
	String baseURL = "http://localhost:8080/api/v1";
	
	@BeforeEach
	public void setup() {
		list  = new ArrayList<Candidate>();
		singleResponse = new ArrayList<Candidate>(); 
		Candidate candidate = new Candidate();
		candidate.setCandidateId(42);
		candidate.setFirstName("Hrishi");
		candidate.setLastName("Shenai");
		candidate.setEmail("Test");
		candidate.setCollege("DJ");
		candidate.setSkill("Java");
		list.add(candidate);
		singleResponse.add(candidate);
		candidate = new Candidate();
		candidate.setCandidateId(43);
		candidate.setEmail("Test1");
		list.add(candidate);
	}
	
	    @Test
		public void testGetAllCandidates() throws Exception{
	    	when(candidateDAO.selectAllCandidate()).thenReturn(list);
	    	this.mockMvc.perform(get(baseURL + "/candidates"))
	    				.andExpect(status().isOk())
	    				.andExpect(jsonPath("$.size()", is(2)));
		}
	    
	    @Test
		public void testGetCandidatesbyId() throws Exception{
	    	when(candidateDAO.selectById(42)).thenReturn(singleResponse);
	    	this.mockMvc.perform(get(baseURL + "/candidates/candidateId=42"))
	    				.andExpect(status().isOk())
	    				.andExpect(jsonPath("$.size()", is(1)))
	    				.andExpect(jsonPath("$[0].candidateId", is(42)));
		}
		
		@Test
		public void testGetCandidatesbyFirstName() throws Exception{
			when(candidateDAO.selectByFirstName("Hrishi")).thenReturn(singleResponse);
	    	this.mockMvc.perform(get(baseURL + "/candidates/firstName=Hrishi"))
	    				.andExpect(status().isOk())
	    				.andExpect(jsonPath("$.size()", is(1)))
	    				.andExpect(jsonPath("$[0].candidateId", is(42)))
	    				.andExpect(jsonPath("$[0].firstName", is("Hrishi")));
		
		}
		
		@Test
		public void testGetCandidatesbyLastName() throws Exception{
			when(candidateDAO.selectByLastName("Shenai")).thenReturn(singleResponse);
	    	this.mockMvc.perform(get(baseURL + "/candidates/lastName=Shenai"))
	    				.andExpect(status().isOk())
	    				.andExpect(jsonPath("$.size()", is(1)))
	    				.andExpect(jsonPath("$[0].candidateId", is(42)))
	    				.andExpect(jsonPath("$[0].lastName", is("Shenai")));
		
		}
		
		@Test
		public void testGetCandidatesbyCollege() throws Exception{
			when(candidateDAO.selectByCollege("DJ")).thenReturn(singleResponse);
	    	this.mockMvc.perform(get(baseURL + "/candidates/college=DJ"))
	    				.andExpect(status().isOk())
	    				.andExpect(jsonPath("$.size()", is(1)))
	    				.andExpect(jsonPath("$[0].candidateId", is(42)))
	    				.andExpect(jsonPath("$[0].college", is("DJ")));
		
		}
		
		@Test
		public void testGetCandidatesbySkill() throws Exception{
			when(candidateDAO.selectBySkill("Java")).thenReturn(singleResponse);
	    	this.mockMvc.perform(get(baseURL + "/candidates/skill=Java"))
	    				.andExpect(status().isOk())
	    				.andExpect(jsonPath("$.size()", is(1)))
	    				.andExpect(jsonPath("$[0].candidateId", is(42)))
	    				.andExpect(jsonPath("$[0].skill", is("Java")));
		
		}
}
