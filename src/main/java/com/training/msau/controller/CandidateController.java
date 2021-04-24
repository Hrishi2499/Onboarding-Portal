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
	
	@GetMapping("/candidates")
	public List<Candidate> getAllCandidates(){
		return candidateDAO.selectWithSkillAll();
	}
	
	@GetMapping("/candidates/candidateId={id}")
	public Candidate getCandidatesbyId(@PathVariable("id") long id){
		return candidateDAO.selectById(id);
	}
		
}
