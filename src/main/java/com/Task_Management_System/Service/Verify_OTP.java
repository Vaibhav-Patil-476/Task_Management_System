package com.Task_Management_System.Service;

import com.Task_Management_System.DTO.VerifyEmailOtpDTO;
import com.Task_Management_System.Response.LoginResponse;

public interface Verify_OTP {

	//This method for Verify email otp
	LoginResponse verifyEmailOTP(VerifyEmailOtpDTO emailOtpDTO);
}
