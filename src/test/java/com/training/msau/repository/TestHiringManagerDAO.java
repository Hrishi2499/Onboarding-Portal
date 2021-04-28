package com.training.msau.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestHiringManagerDAO {
	
	@Autowired
	HiringManagerDAO hiringManagerDAO;
	
	@Test
	public void testSelectAll(){
		assertEquals(2, hiringManagerDAO.selectAll().size());
	}
	
	@Test
	public void testSelectById(){
		assertEquals(101, hiringManagerDAO.selectById(101).getHmId());
	}
	
	@Test
	public void testSelectEmail(){
		assertEquals(102, hiringManagerDAO.selectEmail("manager2@gmail.com").getHmId());
	}

}
