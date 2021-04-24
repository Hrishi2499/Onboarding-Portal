package com.training.msau.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.training.msau.model.CandidateMapper;
import com.training.msau.model.CandidateSkillMapper;
import com.training.msau.exception.ResourceNotFoundException;
import com.training.msau.model.Candidate;


@Repository
public class CandidateDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	CandidateMapper candidateMapper = new CandidateMapper();
	
	@Autowired
	CandidateSkillMapper candidateSkillMapper = new CandidateSkillMapper();
	
	public List<Candidate> selectAll(){
		String sql = "select * from candidate where onboard_started = false";
		return jdbcTemplate.query(sql, candidateMapper);
	}
	
	public List<Candidate> selectWithSkillAll(){
		String sql = "select * from candidate, candidate_skill "
				+ " where candidate.candidate_id = candidate_skill.candidate_id and onboard_started = false";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Candidate>>() {
			
			@Override
			public List<Candidate> extractData(ResultSet rs)  throws SQLException, DataAccessException{
				//List<Candidate> list = new ArrayList<Candidate>();
				Map<Long, Candidate> candidate_map = new HashMap<>();
				while(rs.next()) {
					Long candidateId = rs.getLong("candidate_id");
					if(candidate_map.containsKey(candidateId)) {
						candidate_map.get(candidateId).getSkills().add(rs.getString("skill"));
					}
					else {
						Candidate candidate = new Candidate();
						candidate = candidateMapper.mapRow(rs, 0);
						candidate.getSkills().add(rs.getString("skill"));
						candidate_map.put(candidateId, candidate);						
					}
				}
				return new ArrayList<Candidate>(candidate_map.values());
			}
		});
	}
	
	public Candidate selectById(long id) {
		String sql = "select * from candidate, candidate_skill "
				+ " where candidate.candidate_id = candidate_skill.candidate_id and onboard_started = false and "
				+ " candidate.candidate_id = ?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Candidate>() {
			
			@Override
			public Candidate extractData(ResultSet rs)  throws SQLException, DataAccessException{
				//List<Candidate> list = new ArrayList<Candidate>();
				Candidate candidate = new Candidate();
				rs.next();
				candidate = candidateMapper.mapRow(rs, 0);
				candidate.getSkills().add(rs.getString("skill"));
				while(rs.next()) {
					candidate.getSkills().add(rs.getString("skill"));
				}
				return candidate;
			}
		}, new Object[] {id});
	}	
	
}
