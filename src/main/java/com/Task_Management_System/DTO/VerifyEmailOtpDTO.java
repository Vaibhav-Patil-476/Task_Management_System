package com.Task_Management_System.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyEmailOtpDTO {

	@NotBlank(message = "Email is Required")
	private String email;
	
	@NotNull(message = "Otp is Required")
	
	private Long otp;
}
