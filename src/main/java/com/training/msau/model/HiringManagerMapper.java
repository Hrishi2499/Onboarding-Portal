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
		hm.setHmId((long)rs.getLong("hm_id"));
		hm.setHm_email((String)rs.getString("hm_email"));
		hm.setName((String)rs.getString("username"));
		
		return hm;
	}
}
