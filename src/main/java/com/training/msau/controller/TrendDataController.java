package com.training.msau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.msau.model.TrendData;
import com.training.msau.repository.TrendDataDAO;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class TrendDataController {

	@Autowired
	private TrendDataDAO trendDataDAO;
	
	@GetMapping("/trends/location")
	public TrendData getTrendByLocation(){
		return trendDataDAO.getTrendByLocation();
	}
	@GetMapping("/trends/manager")
	public TrendData getTrendByManager(){
		return trendDataDAO.getTrendByManager();
	}
}
