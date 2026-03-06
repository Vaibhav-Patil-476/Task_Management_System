package com.Task_Management_System.Service;

import com.Task_Management_System.DTO.EmailReqestDTO;
import com.Task_Management_System.Response.EmailResponse;

public interface EmailService {

	//This method for send mail to user 
	EmailResponse sendEmail(EmailReqestDTO emailReqestDTO);
}
