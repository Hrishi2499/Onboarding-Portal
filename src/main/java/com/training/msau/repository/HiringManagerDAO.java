package com.training.msau.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.training.msau.model.HiringManagerMapper;
import com.training.msau.model.HiringManager;

@Repository
public class HiringManagerDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	HiringManagerMapper hiringManagerMapper;
	
	public List<HiringManager> selectAll(){
		String sql = "select * from hiring_manager";
		return jdbcTemplate.query(sql, hiringManagerMapper);
	}
	
	public HiringManager selectById(long id){
		String sql = "select * from hiring_manager where hm_id = ?";
		return jdbcTemplate.queryForObject(sql, hiringManagerMapper, new Object[] {id});
	}
	
	public HiringManager selectEmail(String eMail){
		String sql = "select * from hiring_manager where hm_email = ?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<HiringManager>(){
				
				@Override
				public HiringManager extractData(ResultSet rs)  throws SQLException, DataAccessException{
				HiringManager hm = new HiringManager();
				while(rs.next()) {
					hm = hiringManagerMapper.mapRow(rs,0);
					hm.setPassword(rs.getString("password"));
				}
				return hm;
				}
			} , new Object[] {eMail});
		}
	}
