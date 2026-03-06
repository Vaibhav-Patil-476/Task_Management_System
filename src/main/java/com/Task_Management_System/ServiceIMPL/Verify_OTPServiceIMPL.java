package com.Task_Management_System.ServiceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Task_Management_System.DTO.VerifyEmailOtpDTO;
import com.Task_Management_System.Entity.User;
import com.Task_Management_System.ExceptionHandling.ResourceNotFoundException;
import com.Task_Management_System.Repository.User_Repository;
import com.Task_Management_System.Response.LoginResponse;
import com.Task_Management_System.Service.Verify_OTP;

@Service
public class Verify_OTPServiceIMPL implements Verify_OTP {
	
	@Autowired
	private User_Repository user_Repository;

	@Override
	public LoginResponse verifyEmailOTP(VerifyEmailOtpDTO emailOtpDTO) {
		
		User user = user_Repository.findByEmail(emailOtpDTO.getEmail()).orElseThrow(()-> new ResourceNotFoundException("This Email is not exist...."));
		
		if(!user.getEmailOTP().equals(emailOtpDTO.getOtp())) {
			throw new RuntimeException("Invalid OTP....");
		}
			LoginResponse response = new LoginResponse();
			
			response.setEmail(emailOtpDTO.getEmail());
			response.setMessage("Login Successful....");
			
			return response;
	}

}
