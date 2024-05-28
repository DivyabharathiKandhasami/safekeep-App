package com.userportal.safekeep.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userportal.safekeep.DTO.OtpDto;
import com.userportal.safekeep.entity.AppEntity;
import com.userportal.safekeep.repo.AppRepo;

@Service
public class AppService {

	@Autowired
	AppRepo appRepo;

	@Autowired
	EmailService emailService;

	public void SendOtp(String emailId, String username) {
		// Generate a random OTP
		String otp = generateOtp();
		String subject ="subject";
		String body = "body";

		// Save the OTP to the user's account
		AppEntity appEntity = appRepo.findByUsername(username);
		if (appEntity != null) {
			appEntity.setOtp(otp);
			appEntity.setOtpExpiryTime(getExpiryTime());
			appRepo.save(appEntity);
		}

		// Send the OTP to the user's email
		emailService.sendOtpEmail(emailId,   otp, subject, body);
	}

	private String generateOtp() {
		// Generate a random 6-digit OTP

		return String.valueOf(new Random().nextInt(900000) + 100000);
	}

	private LocalDateTime getExpiryTime() {

		// Set the OTP to expire after 8 minutes

		return LocalDateTime.now().plusMinutes(8);
	}

}
