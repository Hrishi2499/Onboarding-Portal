package com.training.msau.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tokens")
public class Tokens{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tokenId;
	
	@Column(name = "user_id", unique = true)
	private long userId;
	
	@Column(name = "auth_token")
	private String authToken;
	
	@Column(name = "secret_key")
	private String secretKey;
	
	@Column(name = "email_id")
	private String emailId;
	
	public Tokens() {}
	
	public Tokens(long userId, String authToken, String secretKey, String emailId) {
		super();
		this.userId = userId;
		this.authToken = authToken;
		this.secretKey = secretKey;
		this.emailId = emailId;
	}

	public long getTokenId() {
		return tokenId;
	}

	public void setTokenId(long tokenId) {
		this.tokenId = tokenId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
}
