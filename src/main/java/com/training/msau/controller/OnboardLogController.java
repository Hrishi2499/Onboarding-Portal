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

import com.training.msau.model.OnboardLog;
import com.training.msau.repository.OnboardLogDAO;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class OnboardLogController {

	@Autowired
	private OnboardLogDAO onboardLogDAO;
	
	@GetMapping("/onboardLogs")
	public List<OnboardLog> getAllLogs(){
		return onboardLogDAO.selectAllLogs();
	}
	
	@GetMapping("/onboardLogs/candidateId={param}")
	public List<OnboardLog> getLogsByCandidateId(@PathVariable("param") long id){
		return onboardLogDAO.selectLogByCandidateId(id);
	}
	
	@GetMapping("/onboardLogs/onboardId={param}")
	public List<OnboardLog> getLogsByOnboardId(@PathVariable("param") long id){
		return onboardLogDAO.selectLogByOnboardId(id);
	}
	
	@GetMapping("/onboardLogs/user={param}")
	public List<OnboardLog> getLogsByUser(@PathVariable("param") String user){
		return onboardLogDAO.selectLogByUser(user);
	}
	
	@GetMapping("/onboardLogs/year={param}")
	public List<OnboardLog> getLogsByYear(@PathVariable("param") String year){
		return onboardLogDAO.selectLogByYear(year);
	}
	
	@GetMapping("/onboardLogs/date={param}")
	public List<OnboardLog> getLogsByDate(@PathVariable("param") String date){
		return onboardLogDAO.selectLogByDate(date);
	}
	
	@GetMapping("/onboardLogs/month={param}")
	public List<OnboardLog> getLogsByMonth(@PathVariable("param") String month){
		String[] param = month.strip().split("-");
		return onboardLogDAO.selectLogByMonth(param[1], param[0]);
	}
	
	@PutMapping("/onboardLogs")
	public int createOnboardLog(@RequestBody OnboardLog onboardLog){
		return onboardLogDAO.addOnboardLog(onboardLog);
	}
}
