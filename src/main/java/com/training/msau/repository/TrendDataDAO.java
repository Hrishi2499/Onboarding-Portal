package com.training.msau.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.training.msau.model.TrendData;

@Repository
public class TrendDataDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public int getYearCount() {
		String sql = "select count(distinct(year(eta))) as count from onboard";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>(){
			
			@Override
			public Integer extractData(ResultSet rs)  throws SQLException, DataAccessException{
				rs.next();
				return rs.getInt("count");
			}
		});
	}
	
	public int getLocationCount() {
		String sql = "select count(distinct(location)) as count from onboard";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>(){
			
			@Override
			public Integer extractData(ResultSet rs)  throws SQLException, DataAccessException{
				rs.next();
				return rs.getInt("count");
			}
		});
	}
	public int getHmIdCount() {
		String sql = "select count(distinct(hm_id)) as count from onboard";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>(){
			
			@Override
			public Integer extractData(ResultSet rs)  throws SQLException, DataAccessException{
				rs.next();
				return rs.getInt("count");
			}
		});
	}
	
	public TrendData getTrendByLocation() {
		int yearCount = this.getYearCount();
		int colCount = this.getLocationCount();
		
		String sql = "select year(eta), location, count(*) from onboard group by year(eta), location order by year(eta)";
		return jdbcTemplate.query(sql, new ResultSetExtractor<TrendData>() {
			@Override
			public TrendData extractData(ResultSet rs)  throws SQLException, DataAccessException{
				TrendData td = new TrendData();
				td.setName("Distribution by Location");
				List<String> years = new ArrayList<String>();
				List<String> columns = new ArrayList<String>();
				long[][] data = new long[colCount][yearCount];
				
				while(rs.next()) {
					String year = rs.getString("year(eta)");
					if(! years.contains(year)) {
						years.add(year);
					}
					String column = rs.getString("location");
					if(! columns.contains(column)) {
						columns.add(column);
					}
					
					int row = columns.indexOf(column);
					int col = years.indexOf(year);
					
					data[row][col] = rs.getLong("count(*)");
 				}
				td.setYears(years);
				td.setColumns(columns);
				td.setData(data);
				
				return td;
			}
		});
	}
	
	public TrendData getTrendByManager() {
		int yearCount = this.getYearCount();
		int colCount = this.getHmIdCount();
		
		String sql = "select year(eta), hm_id, count(*) from onboard group by year(eta), hm_id order by year(eta)";
		return jdbcTemplate.query(sql, new ResultSetExtractor<TrendData>() {
			@Override
			public TrendData extractData(ResultSet rs)  throws SQLException, DataAccessException{
				TrendData td = new TrendData();
				td.setName("Distribution by Manager");
				List<String> years = new ArrayList<String>();
				List<String> columns = new ArrayList<String>();
				long[][] data = new long[colCount][yearCount];
				
				while(rs.next()) {
					String year = rs.getString("year(eta)");
					if(! years.contains(year)) {
						years.add(year);
					}
					String column = rs.getString("hm_id");
					if(! columns.contains(column)) {
						columns.add(column);
					}
					
					int row = columns.indexOf(column);
					int col = years.indexOf(year);
					
					data[row][col] = rs.getLong("count(*)");
 				}
				td.setYears(years);
				td.setColumns(columns);
				td.setData(data);
				
				return td;
			}
		});
	}
}
