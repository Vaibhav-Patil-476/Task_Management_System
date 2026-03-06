package com.Task_Management_System.Repository;


import java.lang.foreign.Linker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Task_Management_System.Entity.User;

@Repository
public interface User_Repository extends JpaRepository<User, Integer> {

	//Check email is exist and return true or fails 
	Boolean existsByEmail(String email);
	
	
	//Check user are exist with particular email
	Optional<User> findByEmail(String email);
	
	
	
	//Checking mobile no
	Boolean existsByMobileNo(String mobileNo);
}
