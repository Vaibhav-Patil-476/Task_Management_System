package com.Task_Management_System.ServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Task_Management_System.Entity.User;
import com.Task_Management_System.ExceptionHandling.DuplicateException;
import com.Task_Management_System.ExceptionHandling.ResourceNotFoundException;
import com.Task_Management_System.Repository.User_Repository;
import com.Task_Management_System.Service.OTPGenerator;
import com.Task_Management_System.Service.User_Service;


@Service
public class User_ServiceIMPL implements User_Service {

	//import User Repository class
	@Autowired
	private User_Repository userRepository;
	

	//Save User Data
	@Override
	public User saveUser(User user) {


	    if(userRepository.existsByEmail(user.getEmail())) {
	        throw new DuplicateException("This User Email is already Exist....!");
	    }
	    if(userRepository.existsByMobileNo(user.getMobileNo())) {
	        throw new DuplicateException("Mobile number already exists!");
	    }

	    return userRepository.save(user);
	}
	
	


}
