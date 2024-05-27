package com.userportal.safekeep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.userportal.safekeep.DTO.OtpDto;

@Service
public class EmailService {

	@Autowired
	JavaMailSender javamailsender;

	public void sendOtpEmail(String emailId, String otp) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo("divyakandhasami@gmail.com");
		mailMessage.setSubject(
				"OTP Verfication\", \"Hi there,\\n\" + \"\\n\" + \"Thank you for registering with our user management portal 🙌.");
		mailMessage.setText("To complete your registration, please enter the following OTP code:\n" + "\n" + otp + "\n"
				+"This OTP code is valid for 8 minutes only. If you did not request this OTP code, please ignore this email.\n"
				+"\n" + "Best regards,\n" + "The Safe keep Team " + otp);
	}

}
