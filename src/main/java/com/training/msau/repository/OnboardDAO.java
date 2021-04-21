package com.training.msau.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.msau.model.Onboard;
import com.training.msau.model.Candidate;
import com.training.msau.model.CandidateMapper;
import com.training.msau.model.HiringManager;
import com.training.msau.model.HiringManagerMapper;
import com.training.msau.model.OnboardMapper;
import com.training.msau.exception.InsertionException;

@Repository
public class OnboardDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	@Autowired
	OnboardMapper onboardMapper = new OnboardMapper();
	
	@Autowired
	CandidateMapper candidateMapper = new CandidateMapper();
	
	@Autowired
	HiringManagerMapper hmMapper = new HiringManagerMapper();
	
	public List<Onboard> selectAll(){
		String sql = "select * from onboard, candidate, hiring_manager "
				+ "where onboard.candidate_id = candidate.candidate_id and onboard.hm_id = hiring_manager.hm_id";
		
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Onboard>>() {
			
			@Override
			public List<Onboard> extractData(ResultSet rs)  throws SQLException, DataAccessException{
				List<Onboard> list = new ArrayList<Onboard>();
								
				while(rs.next()) {
					Onboard op = new Onboard();
					Candidate candidate = new Candidate();
					HiringManager hm = new HiringManager();
					
					op = onboardMapper.mapRow(rs, 0);
					candidate = candidateMapper.mapRow(rs, 0);
					hm = hmMapper.mapRow(rs, 0);
					
					op.setCandidate(candidate);
					op.setHiringManager(hm);
					
					list.add(op);
				}
				return list;
			}
		});
	}
	
	public Onboard selectOnboardbyCandidateId(long candidate_id){
		String sql = "select * from onboard, candidate, hiring_manager "
				+ " where onboard.candidate_id = candidate.candidate_id and onboard.hm_id = hiring_manager.hm_id "
				+ " and onboard.candidate_id = ?";
		
		return jdbcTemplate.query(sql, new ResultSetExtractor<Onboard>() {
			
			@Override
			public Onboard extractData(ResultSet rs)  throws SQLException, DataAccessException{
					if(rs == null) {
						return null;
					}
					
					rs.next();
					Onboard op = new Onboard();
					Candidate candidate = new Candidate();
					HiringManager hm = new HiringManager();
					
					op = onboardMapper.mapRow(rs, 0);
					candidate = candidateMapper.mapRow(rs, 0);
					hm = hmMapper.mapRow(rs, 0);
					
					op.setCandidate(candidate);
					op.setHiringManager(hm);
					
					return op;
			}
		},
				new Object[] {candidate_id});
	}
	
	@Transactional
	public synchronized Onboard addOnboard(Onboard onboard){
		int result = 0;
		Onboard added = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(new Date());
		
		String sql = "insert into onboard (candidate_id, hm_id,bg_status,onboard_status,eta,start_date) values (?,?,?,?,?,?)";
		Object[] values = new Object[] {onboard.getCandidateId(), onboard.getHmId(),
										onboard.getBgStatus(), onboard.getOnboardStatus(),
										onboard.getEta(), date};
		try {
			result = jdbcTemplate.update(sql, values);
		}catch(DuplicateKeyException exception){
			throw new InsertionException("Cannot Make this entry, EmployeeId: "+onboard.getCandidateId()+ exception);
		}
		if(result == 1) { //insert successful
			added = this.selectOnboardbyCandidateId(onboard.getCandidateId());
		}
		return added;
	}
}
