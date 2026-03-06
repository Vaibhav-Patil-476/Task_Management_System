package com.Task_Management_System.Service;

import com.Task_Management_System.DTO.AuthDTO;
import com.Task_Management_System.Response.LoginResponse;

public interface AuthService {

	//This method for check login 
	LoginResponse userLogin(AuthDTO authDTO);
}
