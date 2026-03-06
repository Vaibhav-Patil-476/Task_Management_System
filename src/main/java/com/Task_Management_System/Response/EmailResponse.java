package com.Task_Management_System.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailResponse {

	private String message;
	
	private boolean success;
	
}
