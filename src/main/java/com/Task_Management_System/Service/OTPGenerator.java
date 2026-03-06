package com.Task_Management_System.Service;

import java.util.Random;

import org.springframework.context.annotation.Configuration;

@Configuration
public class OTPGenerator {

	public long generateOTP(){
		return 1000 + new Random().nextInt(9000);
	}
}
