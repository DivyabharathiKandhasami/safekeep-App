package com.userportal.safekeep.contro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userportal.safekeep.DTO.OtpDto;
import com.userportal.safekeep.service.AppService;

@RestController
@RequestMapping("api/safekeep")
public class AppController {

	@Autowired
	AppService appService;

	@PostMapping("/send-otp")
	public ResponseEntity<String> SendOtp(@RequestBody OtpDto otpDto) {
		String emailId = otpDto.getEmailId();
		String username = otpDto.getUsername();
		appService.SendOtp(emailId, username);

		return ResponseEntity.ok("OTP sent successfully to user email");
	}

}
