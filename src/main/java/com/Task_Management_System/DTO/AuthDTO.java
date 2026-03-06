package com.Task_Management_System.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {

	@NotBlank(message = "Email is Required...")
	private String email;

	@NotNull(message = "Password is Required")
	@Size(min = 6, message = "Password must be at least 6 characters")
	private String password;
}
