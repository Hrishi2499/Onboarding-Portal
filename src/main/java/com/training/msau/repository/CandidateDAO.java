package com.training.msau.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.msau.model.CandidateMapper;
import com.training.msau.model.Candidate;


@Repository
public class CandidateDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	CandidateMapper candidateMapper;
	
	
	public List<Candidate> selectAllCandidate(){
		String sql = "select * from candidate order by onboard_started";
		return jdbcTemplate.query(sql, candidateMapper);
	}
	
	public List<Candidate> selectById(long id) {
		String sql = "select * from candidate "
				+ " where candidate_id = ? order by onboard_started";
		return jdbcTemplate.query(sql, candidateMapper, new Object[] {id});
	}
	
	public List<Candidate> selectByFirstName(String fName) {
		String sql = "select * from candidate "
				+ " where first_name like ? order by onboard_started";
		return jdbcTemplate.query(sql, candidateMapper, new Object[] {"%" + fName + "%"});
	}
	
	public List<Candidate> selectByLastName(String lName) {
		String sql = "select * from candidate "
				+ " where last_name like ? order by onboard_started";
		return jdbcTemplate.query(sql, candidateMapper, new Object[] {"%" + lName + "%"});
	}

	public List<Candidate> selectByCollege(String college) {
		String sql = "select * from candidate "
				+ " where college like ? order by onboard_started";
		return jdbcTemplate.query(sql, candidateMapper, new Object[] {"%" + college + "%"});
	}
	
	public List<Candidate> selectBySkill(String skill) {
		String sql = "select * from candidate "
				+ " where skill like ? order by onboard_started ";
		return jdbcTemplate.query(sql, candidateMapper, new Object[] {"%" + skill + "%"});
	}

}

