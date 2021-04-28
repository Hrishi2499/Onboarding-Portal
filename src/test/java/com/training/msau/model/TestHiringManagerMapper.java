package com.training.msau.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestHiringManagerMapper {

	@Mock
	private ResultSet rs;
	
	@Autowired
	HiringManagerMapper hmMapper;
	
	@Test
	public void testMapRow() throws SQLException{
		long hmId = 101;
		String name = "Manage 1";
		String hm_email = "sample@gmail.com";
		
		Mockito.when(rs.getLong("hm_id")).thenReturn(hmId);
		Mockito.when(rs.getString("username")).thenReturn(name);
		Mockito.when(rs.getString("hm_email")).thenReturn(hm_email);
		
		HiringManager hm = hmMapper.mapRow(rs, 0);
		
		assertNotNull(hm);
		assertEquals(hmId, hm.getHmId());
		assertEquals(name, hm.getName());
		assertEquals(hm_email, hm.getHm_email());
	}
}
