package com.training.msau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.msau.repository.HiringManagerDAO;
import com.training.msau.model.HiringManager;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class HiringManagerController {
	
	@Autowired
	HiringManagerDAO hiringManagerDAO;
	
	@GetMapping("/hiringManagers")
	public List<HiringManager> getAllHiringManagers(){
		return this.hiringManagerDAO.selectAll();		
	}
	
	@GetMapping("/hiringManagers/hmEmail={hmEmail}")
	public HiringManager getHiringManagerByEmail(@PathVariable("hmEmail") String hmEmail){
		return this.hiringManagerDAO.selectEmail(hmEmail);		
	}

}
