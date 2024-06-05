package com.userportal.safekeep.DTO;

import jakarta.persistence.Entity;
import lombok.Data;

@Data

public class OtpDto {

	// sign up Dto

	private String username;
	private String emailId;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getEmailId() 
	{
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
