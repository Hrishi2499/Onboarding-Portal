package com.training.msau.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	
	public List<HiringManager> selectByName(String name){
		String sql = "select * from hiring_manager where name like %?%";
		return jdbcTemplate.query(sql, hiringManagerMapper, new Object[] {name});
	}
}
