package com.training.msau.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestHiringManager {

	@Autowired
	HiringManager hiringManager;
	
	@Test
	public void testGetterSetterHmId() {
		long hmId = 101;
		assertEquals(hmId, hiringManager.setHmId(hmId).getHmId());
	}
	
	@Test
	public void testGetterSetterName() {
		String name = "Manager Name";
		assertEquals(name, hiringManager.setName(name).getName());
	}
	
	@Test
	public void testGetterSetterEmail() {
		String email = "Manager@gmail.com";
		assertEquals(email, hiringManager.setHm_email(email).getHm_email());
	}
	
	@Test
	public void testGetterSetterPassword() {
		String password = "password";
		assertEquals(password, hiringManager.setPassword(password).getPassword());
	}
}
