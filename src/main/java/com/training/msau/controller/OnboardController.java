package com.training.msau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.msau.model.Onboard;
import com.training.msau.repository.OnboardDAO;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class OnboardController {
	
	@Autowired
	private OnboardDAO onboardDAO;
	
	@GetMapping("/onboards")
	public List<Onboard> getAllOnboards(){
		return onboardDAO.selectAll();
	}
	
	@GetMapping("/onboards/candidateId={id}")
	public Onboard getOnboardById(@PathVariable("id") long id){
		return onboardDAO.selectOnboardbyCandidateId(id);
	}
	
	@PutMapping("/onboards")
	public Onboard createOnboard(@RequestBody Onboard onboard){
		return onboardDAO.addOnboard(onboard);
	}
	
}
