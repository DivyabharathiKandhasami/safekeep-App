package com.userportal.safekeep;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;

import com.userportal.safekeep.service.EmailService;

@SpringBootApplication
public class SafekeepApplication {

	@Autowired
	EmailService emailservice;
	@Autowired
	JavaMailSender javamailsender;

	public static void main(String[] args) {
		SpringApplication.run(SafekeepApplication.class, args);
	}

	private String generateOtp() {

		return String.valueOf(new Random().nextInt(900000) + 100000);
	}

	@EventListener(ApplicationReadyEvent.class)
	public Object sendMail() {
		String otp = generateOtp();
		emailservice.sendOtpEmail("divyakandhasami@gmail.com", otp, "OTP REGISTER", "Please enter the otp");

		System.out.println("otp send Successfully (❁´◡`❁)");
		return javamailsender;

	}

}
