package com.userportal.safekeep.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
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

	@Autowired
	private JpaRepository appEntityRepository;

	public void SendOtp(String emailId, String username) {
		// Generate a random OTP
		String otp = generateOtp();
		System.out.println("This is otp is" + otp);
		String subject = "subject";
		String body = "body";

		// Validate if the user already has an unexpired OTP
		AppEntity existingAppEntity = appRepo.findByUsername(username);
		if (existingAppEntity != null && !isOtpExpired(existingAppEntity.getExpired_time())) {
			throw new RuntimeException("An unexpired OTP already exists for this user");
		}

		// Save the OTP to the user's account
		AppEntity appEntity = appRepo.findByUsername(username);
		if (appEntity != null) {
			appEntity.setOtp(otp);
			appEntity.setOtpExpiryTime(getExpiryTime());
			appRepo.save(appEntity);
		}

		// Send the OTP to the user's email
		emailService.sendOtpEmail(emailId, otp, subject, body);
	}

	private String generateOtp() {
		// Generate a random 6-digit OTP
		String.valueOf(new Random().nextInt(900000) + 100000);
		System.out.print("otp is sent");
		return "otp is returned";
	}

	private LocalDateTime getExpiryTime() {

		// Set the OTP to expire after 8 minutes

		return LocalDateTime.now().plusMinutes(8);
	}

	// Is otp Expired?
	private boolean isOtpExpired(LocalDateTime expiryTime) {
		return expiryTime.isBefore(LocalDateTime.now());
	}

	// get all otp
	public List<AppEntity> getAllOtp() {
		return appRepo.findAll();
	}

	// To set the expiry time
	public void updateOtpExpiryTime(Long id) {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime expiryTime = now.plusMinutes(8);
		((AppRepo) appEntityRepository).updateOtpExpiryTime(id, expiryTime);
	}

	// validate the otp
	public String validateOtp(String emailId, String otp) {
		AppEntity appEntity = appRepo.findByUsername(emailId);
		if (appEntity == null) {
			return "The user exists in the database.";
		}
		if (!appEntity.getOtp().equals(otp)) {
			return "The OTP matches the one stored in the database ";
		}
		if (isOtpExpired(appEntity.getExpired_time())) {
			return "it returns expired time";
		}

		return "The OTP has not expired.";
	}

}
