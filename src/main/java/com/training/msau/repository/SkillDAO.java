package com.training.msau.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.msau.model.SkillMapper;
import com.training.msau.model.Skill;

@Repository
public class SkillDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	SkillMapper skillMapper;
	
	public List<Skill> selectAll(){
		String sql = "select * from Skill";
		return jdbcTemplate.query(sql, skillMapper);
	}
	
	public Skill selectById(long id){
		String sql = "select * from Skill where skill_id = ?";
		return jdbcTemplate.queryForObject(sql, skillMapper, new Object[] {id});
	}
	
	public List<Skill> selectBySkill(String skill){
		String sql = "select * from Skill where skill like %?%";
		return jdbcTemplate.query(sql, skillMapper, new Object[] {skill});
	}
}
