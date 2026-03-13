package com.Task_Management_System.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//This class Create For Pass Valid Responce to user
public class EmailResponse {

	private String message;
	
	private boolean success;
	
}
