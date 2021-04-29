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

import com.training.msau.model.HiringManager;
import com.training.msau.repository.HiringManagerDAO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HiringManagerController.class)
public class TestHiringManagerController {

	@InjectMocks
    HiringManagerController hmController;
     
    @MockBean
    HiringManagerDAO hmDAO;
    
    @Autowired                           
    private MockMvc mockMvc;

	List<HiringManager> list;
	List<HiringManager> singleResponse;
	
	String baseURL = "http://localhost:8080/api/v1";
	
	@BeforeEach
	public void setup() {
		list  = new ArrayList<HiringManager>();
		singleResponse = new ArrayList<HiringManager>(); 
		HiringManager hm = new HiringManager();
		hm.setHmId(101);
		hm.setHm_email("Sample");
		list.add(hm);
		singleResponse.add(hm);
		hm = new HiringManager();
		hm.setHmId(102);
		hm.setHm_email("Sample2");
		list.add(hm);
	}
	
	@Test
	public void testGetAllHMs() throws Exception{
    	when(hmDAO.selectAll()).thenReturn(list);
    	this.mockMvc.perform(get(baseURL + "/hiringManagers"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.size()", is(2)));
	}
	
	@Test
	public void testGetHmByEmail() throws Exception{
    	when(hmDAO.selectEmail("Sample")).thenReturn(list.get(0));
    	this.mockMvc.perform(get(baseURL + "/hiringManagers/hmEmail=Sample"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.hmId", is(101)))
    				.andExpect(jsonPath("$.hm_email", is("Sample")));
	}

	@Test
	public void testGetHmById() throws Exception{
    	when(hmDAO.selectById(101)).thenReturn(list.get(0));
    	this.mockMvc.perform(get(baseURL + "/hiringManagers/hmId=101"))
    				.andExpect(status().isOk())
    				.andExpect(jsonPath("$.hmId", is(101)));
	}
	
}
