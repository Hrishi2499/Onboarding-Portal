package com.training.msau.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.msau.model.Candidate;
import com.training.msau.repository.CandidateDAO;

@RestController
@RequestMapping("/api/v1/")
public class CandidateController {

	@Autowired
	private CandidateDAO candidateDAO;
	
	@GetMapping("/candidates")
	public List<Candidate> getAllCandidates(){
		return candidateDAO.selectAll();
	}
	
	@GetMapping("/candidates/{id}")
	public Candidate getCandidatesbyId(@PathVariable("id") long id){
		return candidateDAO.selectById(id);
	}
	
	@GetMapping("/candidates/email={email}")
	public Candidate getCandidateByEmail(@PathVariable("email") String email) {
		return candidateDAO.selectByEmail(email);
	}
	
	@GetMapping("/candidates/college={college}")
	public List<Candidate> getCandidatesByCollege(@PathVariable("college") String college) {
		return candidateDAO.selectByCollege(college);
	}
	
	@GetMapping("/candidates/fName={fName}")
	public List<Candidate> getCandidatesByfName(@PathVariable("fName") String fName) {
		return candidateDAO.selectByFirstName(fName);
	}
	
	@GetMapping("/candidates/lName={lName}")
	public List<Candidate> getCandidatesBylName(@PathVariable("lName") String lName) {
		return candidateDAO.selectByLastName(lName);
	}
	
	@GetMapping("/candidates/full")
	public List<Candidate> getCandidatesByFullName(@RequestParam Map<String, String> fullName) {
		return candidateDAO.selectByFullName(fullName.get("first"), fullName.get("last"));
	}
		
}
