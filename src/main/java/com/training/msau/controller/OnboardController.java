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
		return onboardDAO.selectAllOnboards();
	}
	
	@GetMapping("/onboards/candidateId={id}")
	public List<Onboard> getOnboardByCandidateId(@PathVariable("id") long id){
		return onboardDAO.selectOnboardByCandidateId(id);
	}
	
	@GetMapping("/onboards/onboardId={id}")
	public List<Onboard> getOnboardByOnboardId(@PathVariable("id") long id){
		return onboardDAO.selectOnboardByOnboardId(id);
	}
	
	@GetMapping("/onboards/hmId={hmId}")
	public List<Onboard> getOnboardByhmId(@PathVariable("hmId") long hmId){
		return onboardDAO.selectOnboardByHmId(hmId);
	}
	
	@GetMapping("/onboards/location={location}")
	public List<Onboard> getOnboardByLocation(@PathVariable("location") String location){
		return onboardDAO.selectOnboardByLocation(location);
	}
	
	@GetMapping("/onboards/skill={skill}")
	public List<Onboard> getOnboardBySkill(@PathVariable("skill") String skill){
		return onboardDAO.selectOnboardBySkill(skill);
	}
	
	@GetMapping("/onboards/firstName={fName}")
	public List<Onboard> getOnboardByFirstName(@PathVariable("fName") String fName){
		return onboardDAO.selectOnboardByFirstName(fName);
	}
	
	@GetMapping("/onboards/lastName={lName}")
	public List<Onboard> getOnboardByLastName(@PathVariable("lName") String lName){
		return onboardDAO.selectOnboardByLastName(lName);
	}
	
	@GetMapping("/onboards/college={college}")
	public List<Onboard> getOnboardByCollege(@PathVariable("college") String college){
		return onboardDAO.selectOnboardByCollege(college);
	}
	
	@GetMapping("/onboards/managerName={manager}")
	public List<Onboard> getOnboardByManagerName(@PathVariable("manager") String manager){
		return onboardDAO.selectOnboardByManagerName(manager);
	}
	
	@GetMapping("/onboards/onboardStatus={status}")
	public List<Onboard> getOnboardByOnboardStatus(@PathVariable("status") String status){
		return onboardDAO.selectOnboardByOnboardStatus(status);
	}
	
	@PutMapping("/onboards")
	public List<Onboard> createOnboard(@RequestBody Onboard onboard){
		return onboardDAO.addOnboard(onboard);
	}
	
	@PostMapping("/onboards")
	public List<Onboard> updateOnboard(@RequestBody Onboard onboard){
		return onboardDAO.updateOnboard(onboard);
	}
	
	@DeleteMapping("/onboards/onboardId={onboardId}&user={user}&userEmail={userEmail}")
	public List<Onboard> deleteOnboard(@PathVariable("onboardId") long onboardId,
									   @PathVariable("user") String user,
									   @PathVariable("userEmail") String userEmail){
		return onboardDAO.deleteOnboard(onboardId,user,userEmail);
	}
	
}
