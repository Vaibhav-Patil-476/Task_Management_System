package com.Task_Management_System.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Task_Management_System.DTO.AuthDTO;
import com.Task_Management_System.DTO.VerifyEmailOtpDTO;
import com.Task_Management_System.Response.LoginResponse;
import com.Task_Management_System.Service.AuthService;
import com.Task_Management_System.Service.Verify_OTP;
import com.Task_Management_System.ServiceIMPL.Verify_OTPServiceIMPL;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private Verify_OTP verify_OTP;
	
	@PostMapping("/login/user")
	public LoginResponse userLogin(@Valid @RequestBody AuthDTO authDTO) {
		
		return authService.userLogin(authDTO);
	}
	
	@PostMapping("/email/verify-otp")
	public LoginResponse verifyEmailOtp(@Valid @RequestBody VerifyEmailOtpDTO emailOtpDTO) {
		
		return verify_OTP.verifyEmailOTP(emailOtpDTO);
	}
}
