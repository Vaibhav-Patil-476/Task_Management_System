package com.Task_Management_System.ServiceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Task_Management_System.DTO.EmailReqestDTO;
import com.Task_Management_System.Entity.User;
import com.Task_Management_System.Repository.User_Repository;
import com.Task_Management_System.Response.EmailResponse;
import com.Task_Management_System.Service.EmailService;
import com.Task_Management_System.Service.OTPGenerator;

@Service
public class EmailServiceIMPL implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private OTPGenerator otpGenerator;

	@Autowired
	private User_Repository user_Repository;

	@Override
	public EmailResponse sendEmail(EmailReqestDTO emailReqestDTO) {

		EmailResponse response = new EmailResponse();

		Long otp = otpGenerator.generateOTP();
		
		// Find user by email
		User user = user_Repository.findByEmail(emailReqestDTO.getTo())
				.orElseThrow(() -> new RuntimeException("User not found with this Email"));

		// Save OTP in user
		user.setEmailOTP(otp);
		
		// Save to database
		user_Repository.save(user);

		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			mailMessage.setTo(emailReqestDTO.getTo());
			mailMessage.setSubject("Send OTP");
			mailMessage.setText("Your OTP is:" + otp);

			javaMailSender.send(mailMessage);

			response.setSuccess(true);
			response.setMessage("Email sent succefully.....");

		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage("Failed to sent Email.......");
		}

		return response;
	}

}
