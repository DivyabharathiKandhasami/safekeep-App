package com.userportal.safekeep.contro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userportal.safekeep.DTO.OtpDto;
import com.userportal.safekeep.entity.AppEntity;
import com.userportal.safekeep.service.AppService;
import com.userportal.safekeep.service.MyService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("api/safekeep")
public class AppController {

	/*
	 * @Autowired AppService appService;
	 * 
	 * @Autowired private MyService myService;
	 * 
	 * private String otp = appService.generateOtp();
	 * 
	 * public void testSetOtp() { myService.set("otp" + otp); }
	 */

	@Autowired
	AppService appService;

	@Autowired
	private MyService myService;

	private String otp;

	@PostConstruct
	public void initializeOtp()
	{
		otp = appService.generateOtp();
	}

	public void testSetOtp()
	{
		myService.set("otp" + otp, otp);
	}
 
	@PostMapping("/send-otp")
	public ResponseEntity<String> SendOtp(@RequestBody OtpDto otpDto) {
		String emailId = otpDto.getEmailId();
		String username = otpDto.getUsername();

		appService.SendOtp(emailId, username);

		return ResponseEntity.ok("OTP sent successfully to user email");
	}

	@GetMapping("/getall/users")
	public List<AppEntity> getAllOtp()
	{
		return appService.getAllOtp();
	}

}
