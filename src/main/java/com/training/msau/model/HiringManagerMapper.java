package com.training.msau.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class HiringManagerMapper implements RowMapper<HiringManager>{
	
	@Override
	public HiringManager mapRow(ResultSet rs, int rowNum) throws SQLException{
		HiringManager hm = new HiringManager();
		hm.setEmailId(rs.getString("email"));
		hm.sethId(rs.getLong("hm_id"));
		hm.setName(rs.getString("name"));
		
		return hm;
	}
}
