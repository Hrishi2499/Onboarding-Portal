package com.training.msau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.msau.model.Candidate;
import com.training.msau.repository.CandidateDAO;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {

	@Autowired
	private CandidateDAO candidateDAO;
	
	public CandidateDAO getDAO() {
		return this.candidateDAO;
	}
	
	@GetMapping("/candidates")
	public List<Candidate> getAllCandidates(){
		return candidateDAO.selectAllCandidate();
	}
	
	@GetMapping("/candidates/candidateId={param}")
	public List<Candidate> getCandidatesbyId(@PathVariable("param") long id){
		return candidateDAO.selectById(id);
	}
	
	@GetMapping("/candidates/firstName={param}")
	public List<Candidate> getCandidatesbyFirstName(@PathVariable("param") String param){
		return candidateDAO.selectByFirstName(param);
	}
	
	@GetMapping("/candidates/lastName={param}")
	public List<Candidate> getCandidatesbyLastName(@PathVariable("param") String param){
		return candidateDAO.selectByLastName(param);
	}
	
	@GetMapping("/candidates/college={param}")
	public List<Candidate> getCandidatesbyCollege(@PathVariable("param") String param){
		return candidateDAO.selectByCollege(param);
	}
	
	@GetMapping("/candidates/skill={param}")
	public List<Candidate> getCandidatesbySkill(@PathVariable("param") String param){
		return candidateDAO.selectBySkill(param);
	}
		
}
