package com.Task_Management_System.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailReqestDTO {
	
	private String to;
	
	private String subject;
	
	private String message;
	

}
