package com.training.msau.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.msau.exception.ResourceNotFoundException;
import com.training.msau.model.Onboard;
import com.training.msau.model.OnboardLog;
import com.training.msau.model.OnboardLogMapper;
import com.training.msau.model.OnboardMapper;

@Repository
public class OnboardLogDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	@Autowired
	OnboardLogMapper onboardLogMapper = new OnboardLogMapper();
	
	@Autowired
	OnboardMapper onboardMapper = new OnboardMapper();
	
	public List<OnboardLog> selectAllLogs(){
		return this.selectOnboardLogbyOneField("all", null);
	}
	
	public List<OnboardLog> selectLogByCandidateId(long id){
		return this.selectOnboardLogbyOneField("candidateId", new Object[] {id});
	}
	
	public List<OnboardLog> selectLogByOnboardId(long id){
		return this.selectOnboardLogbyOneField("onboardId", new Object[] {id});
	}
	
	public List<OnboardLog> selectLogByUser(String user){
		return this.selectOnboardLogbyOneField("user", new Object[] {"%" + user + "%"});
	}
	
	public List<OnboardLog> selectLogByYear(String year){
		return this.selectOnboardLogbyOneField("year", new Object[] {year});
	}
	
	public List<OnboardLog> selectLogByMonth(String month, String year){
		return this.selectOnboardLogbyOneField("month", new Object[] {month, year});
	}
	
	public List<OnboardLog> selectLogByDate(String date){
		return this.selectOnboardLogbyOneField("date", new Object[] {date});
	}
	
	
	public List<OnboardLog> selectOnboardLogbyOneField(String field, Object[] param) {
		String baseSql = "select * from onboard_log ";
		
		switch(field) {
			case "all"        : break;
			case "candidateId": baseSql +=  " where candidate_id = ? ";
								break;
			case "onboardId"  : baseSql +=  " where onboard_id = ? ";
								break;
			case "user"       : baseSql +=  " where user like ? ";
								break;		
			case "year"       : baseSql +=  " where year(time_stamp) = ? ";
							    break;
			case "month"      : baseSql +=  " where month(time_stamp) = ? and year(time_stamp) = ? ";
		    					break;
			case "date"       : baseSql +=  " where date(time_stamp) = ? ";
								break;
			default:
						throw new ResourceNotFoundException("Invalid option");
			
		}
			baseSql += " order by log_id desc";
			return this.jdbcTemplate.query(baseSql, new ResultSetExtractor<List<OnboardLog>>(){
			
			@Override
			public List<OnboardLog> extractData(ResultSet rs) throws SQLException, DataAccessException{
				List<OnboardLog> list = new ArrayList<>();
				while(rs.next()) {
					OnboardLog onboardLog = new OnboardLog();
					Onboard onboard = new Onboard();
					onboardLog = onboardLogMapper.mapRow(rs, 0);
					onboard = onboardMapper.mapRow(rs, 0);
					onboardLog.setOnboard(onboard);
					list.add(onboardLog);
				}
				return list;
			}
		}, param);
	}
	
	@Transactional
	public synchronized int addOnboardLog(OnboardLog onboardLog){
		int result = 0;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		String sql = "insert into onboard_log(time_stamp, user, user_email, "
					+ " action, onboard_id, "
					+ " candidate_id, hm_id, "
					+ " onboard_status, eta, "
					+ " start_date, location, "
					+ " bg_status, graduation, training) "
					+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Object[] values = new Object[] {timestamp, onboardLog.getOnboard().getUser(), onboardLog.getOnboard().getUserEmail(), 
										onboardLog.getAction(), onboardLog.getOnboard().getOnboardId(), 
										onboardLog.getOnboard().getCandidateId(), onboardLog.getOnboard().getHmId(), 
										onboardLog.getOnboard().getOnboardStatus(), onboardLog.getOnboard().getEta(),
										onboardLog.getOnboard().getStartDate(), onboardLog.getOnboard().getLocation(),
										onboardLog.getOnboard().isBgStatus(), onboardLog.getOnboard().isGraduation(), onboardLog.getOnboard().isTraining()};
		try {
			result = jdbcTemplate.update(sql, values);
		}catch(DuplicateKeyException exception){
			throw new DataIntegrityViolationException("Cannot Make this entry" + exception);
		}
		
		return result;
	}
	

}
