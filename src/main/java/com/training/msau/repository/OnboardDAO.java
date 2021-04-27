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
import com.training.msau.model.OnboardLog;
import com.training.msau.model.Candidate;
import com.training.msau.model.CandidateMapper;
import com.training.msau.model.HiringManager;
import com.training.msau.model.HiringManagerMapper;
import com.training.msau.model.OnboardMapper;
import com.training.msau.exception.InsertionException;
import com.training.msau.exception.ResourceNotFoundException;

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
	
	@Autowired
	OnboardLogDAO onboardLogDAO = new OnboardLogDAO();
	
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
	
	public List<Onboard> selectOnboardbyOneField(String field, Object[] param) {
		String baseSql = "select * from onboard, candidate, hiring_manager "
				+ " where onboard.candidate_id = candidate.candidate_id and onboard.hm_id = hiring_manager.hm_id ";
		
		switch(field) {
			case "all"        : break;
			case "candidateId": baseSql +=  " and onboard.candidate_id = ?";
								break;
			case "onboardId"  : baseSql +=  " and onboard.onboard_id = ?";
								break;
			case "hmId"       : baseSql +=  " and onboard.hm_id = ?";
								break;		
			case "location"   : baseSql +=  " and onboard.location like ?";
							    break;
			case "skill"      : baseSql +=  " and candidate.skill like ?";
		    					break;
			case "firstName"  : baseSql +=  " and candidate.first_name like ?";
								break;
			case "lastName"   : baseSql +=  " and candidate.last_name like ?";
								break;
			case "college"    : baseSql +=  " and candidate.college like ?";
								break;
			case "managerName": baseSql +=  " and hiring_manager.username like ?";
								break;
			case "onboardStatus": baseSql +=  " and onboard.onboard_status like ?";
								break;
			default:
						throw new ResourceNotFoundException("Invalid option");
			
		}
		return jdbcTemplate.query(baseSql, new ResultSetExtractor<List<Onboard>>() {
			
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
		}, param);
	}
	
	@Transactional
	public synchronized List<Onboard> addOnboard(Onboard onboard){
		int result = 0;
		String onboardStatus = "Started";
		List<Onboard> added = new ArrayList<>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(new Date());
		
		String sql = "insert into onboard (candidate_id, hm_id, onboard_status,eta, start_date, location, "
					+ "	bg_status, graduation, training, user, user_email) "
					+ " values (?,?,?,?,?,?,?,?,?,?,?)";
		
		if(onboard.isBgStatus() && onboard.isGraduation() && onboard.isTraining())
			onboardStatus = "Completed";
		if(onboard.isBgStatus() || onboard.isGraduation() || onboard.isTraining())
			onboardStatus = "In Progress";
		
		Object[] values = new Object[] {onboard.getCandidateId(), onboard.getHmId(), onboardStatus,
										onboard.getEta(), date, onboard.getLocation(),
										onboard.isBgStatus(), onboard.isGraduation(), onboard.isTraining(),
										onboard.getUser(), onboard.getUserEmail()};
		try {
			result = jdbcTemplate.update(sql, values);
		}catch(DuplicateKeyException exception){
			throw new InsertionException("Cannot Make this entry, EmployeeId: "+onboard.getCandidateId()+ exception);
		}
		if(result == 1) { //insert successful
			added = selectOnboardbyOneField("candidateId", new Object[] {onboard.getCandidateId()});
			//Update the status of candidate so that the candidate is not displayed in candidate list
			String updateQuery = "update candidate set onboard_started = true where candidate_id = ?";
			this.jdbcTemplate.update(updateQuery, onboard.getCandidateId());
			
			OnboardLog onboardLog = new OnboardLog();
			onboardLog.setAction("Insert");
			onboardLog.setOnboard(added.get(0));
			this.onboardLogDAO.addOnboardLog(onboardLog);
		}
		return added;
	}
	
	@Transactional
	public synchronized List<Onboard> updateOnboard(Onboard onboard){
		int result = 0;
		String onboardStatus = "Started";
		List<Onboard> updated = new ArrayList<>();
		
		String sql = "update onboard set hm_id = ?, onboard_status = ?,eta = ?,location = ?, "
					+ " bg_status = ?, graduation = ?, training = ? "
					+ " where onboard_id = ?";
		
		if(onboard.isBgStatus() && onboard.isGraduation() && onboard.isTraining())
			onboardStatus = "Completed";
		else if(onboard.isBgStatus() || onboard.isGraduation() || onboard.isTraining())
			onboardStatus = "In Progress";
		
		Object[] values = new Object[] {onboard.getHmId(), onboardStatus, onboard.getEta(), onboard.getLocation(), 
										onboard.isBgStatus(), onboard.isGraduation(), onboard.isTraining(), 
										onboard.getOnboardId()};
		try {
			result = jdbcTemplate.update(sql, values);
		}catch(DuplicateKeyException exception){
			throw new ResourceNotFoundException("Cannot Update this entry, Onboard of : "+onboard.getCandidateId()+ " does not exist");
		}
		if(result == 1) { //update successful
			updated = selectOnboardbyOneField("candidateId", new Object[] {onboard.getCandidateId()});
			
			OnboardLog onboardLog = new OnboardLog();
			onboardLog.setAction("Update");
			onboardLog.setOnboard(updated.get(0));
			this.onboardLogDAO.addOnboardLog(onboardLog);
		}
		
		return updated;
	}
	
	@Transactional
	public synchronized List<Onboard> deleteOnboard(long onboardId, String user, String userEmail){
		int result = 0;
		List<Onboard> deleted;
		deleted = selectOnboardbyOneField("onboardId", new Object[] {onboardId});
		if(deleted.isEmpty())
			return null;
		String sql = "delete from onboard where onboard_id = ?";
		Object[] values = new Object[] {onboardId};
		try {
			result = jdbcTemplate.update(sql, values);
		}catch(Exception exception){
			throw new ResourceNotFoundException("Cannot delete this entry, Onboard of : "+onboardId+ " does not exist");
		}
		
		if(result == 0) { //delete unsuccessful
			deleted = null;
		}
		
		else {
			long candidateId = deleted.get(0).getCandidateId();
			String updateSql = "update candidate set onboard_started = false where candidate_id= ?";
			jdbcTemplate.update(updateSql, candidateId);
			
			OnboardLog onboardLog = new OnboardLog();
			onboardLog.setAction("Delete");
			deleted.get(0).setUser(user);
			deleted.get(0).setUserEmail(userEmail);
			onboardLog.setOnboard(deleted.get(0));
			this.onboardLogDAO.addOnboardLog(onboardLog);
		}
		return deleted;
	}
}
