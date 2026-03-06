package com.Task_Management_System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Task_Management_System.DTO.EmailReqestDTO;
import com.Task_Management_System.Response.EmailResponse;
import com.Task_Management_System.Service.EmailService;

@RestController
@RequestMapping("/auth/send/")
public class EmailContoller {

	@Autowired
	private EmailService emailService;
	
	@PostMapping("/mail")
	public EmailResponse sendEmail(@RequestBody EmailReqestDTO emailReqestDTO){
		
		return emailService.sendEmail(emailReqestDTO);
		
	}
}
