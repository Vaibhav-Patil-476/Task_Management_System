package com.Task_Management_System.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//make Login Response
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

	private String email;

	private String message;


}