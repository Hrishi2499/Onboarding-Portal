package com.training.msau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		return onboardDAO.selectOnboardbyOneField("all", new Object[] {});
	}
	
	@GetMapping("/onboards/candidateId={id}")
	public Onboard getOnboardByCandidateId(@PathVariable("id") long id){
		return onboardDAO.selectOnboardbyOneField("candidateId", new Object[] {id}).get(0);
	}
	
	@GetMapping("/onboards/onboardId={id}")
	public Onboard getOnboardByOnboardId(@PathVariable("id") long id){
		return onboardDAO.selectOnboardbyOneField("onboardId", new Object[] {id}).get(0);
	}
	
	@GetMapping("/onboards/location={loc}")
	public List<Onboard> getOnboardByLocation(@PathVariable("loc") String loc){
		return onboardDAO.selectOnboardbyOneField("location", new Object[] {loc});
	}
	
	@PutMapping("/onboards")
	public List<Onboard> createOnboard(@RequestBody Onboard onboard){
		return onboardDAO.addOnboard(onboard);
	}
	
	@PostMapping("/onboards")
	public List<Onboard> updateOnboard(@RequestBody Onboard onboard){
		return onboardDAO.updateOnboard(onboard);
	}
	
	@DeleteMapping("/onboards/onboardId={onboardId}")
	public List<Onboard> deleteOnboard(@PathVariable long onboardId){
		return onboardDAO.deleteOnboard(onboardId);
	}
	
}
