package com.training.msau.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.msau.model.CandidateMapper;
import com.training.msau.model.Candidate;


@Repository
public class CandidateDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	CandidateMapper candidateMapper = new CandidateMapper();
	
	public List<Candidate> selectAll(){
		String sql = "select * from candidate";
		return jdbcTemplate.query(sql, candidateMapper);
	}
	
	public Candidate selectById(long id) {
		String sql = "select * from candidate where candidate_id = ?";
		return jdbcTemplate.queryForObject(sql, candidateMapper, new Object[] {id});
	}
	
	public Candidate selectByEmail(String email) {
		String sql = "select * from candidate where email = ?";
		return jdbcTemplate.queryForObject(sql, candidateMapper, new Object[] {email});
	}
	
	public List<Candidate> selectByCollege(String college){
		String sql = "select * from candidate where college = ?";
		return jdbcTemplate.query(sql, candidateMapper, new Object[] {college});
	}
	
	public List<Candidate> selectByFirstName(String firstName){
		String sql = "select * from candidate where first_name = ?";
		return jdbcTemplate.query(sql, candidateMapper, new Object[] {firstName});
	}
	
	public List<Candidate> selectByLastName(String lastName){
		String sql = "select * from candidate where last_name = ?";
		return jdbcTemplate.query(sql, candidateMapper, new Object[] {lastName});
	}
	
	public List<Candidate> selectByFullName(String firstName, String lastName){
		String sql = "select * from candidate where first_name = ? and last_name = ?";
		return jdbcTemplate.query(sql, candidateMapper, new Object[] {firstName, lastName});
	}
	
}
