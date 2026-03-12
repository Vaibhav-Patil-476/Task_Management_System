package com.Task_Management_System.ServiceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Task_Management_System.DTO.AuthDTO;
import com.Task_Management_System.Entity.User;
import com.Task_Management_System.ExceptionHandling.ResourceNotFoundException;
import com.Task_Management_System.Repository.User_Repository;
import com.Task_Management_System.Response.LoginResponse;
import com.Task_Management_System.Service.AuthService;

@Service
public class AuthServiceIMPL implements AuthService {

	@Autowired
	private User_Repository user_Repository;
	
	@Override
	public LoginResponse userLogin(AuthDTO authDTO) {
		 	//Find User by email and store all user data into the Object 
			User user=user_Repository.findByEmail(authDTO.getEmail()).orElseThrow(() -> new ResourceNotFoundException("Email not found"));

			if (!user.getPassword().equals(authDTO.getPassword())) {
				throw new RuntimeException("Invalid  Password...!");
			}
			
			LoginResponse response = new LoginResponse();
			
			response.setEmail(authDTO.getEmail());
			response.setMessage("Login Succefully....!");
			
			return response;
	}

}
