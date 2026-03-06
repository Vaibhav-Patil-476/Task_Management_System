package com.Task_Management_System.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Task_Management_System.DTO.UserDTO;
import com.Task_Management_System.Entity.User;

import com.Task_Management_System.Service.User_Service;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class User_Contoller {

	
	@Autowired
	private User_Service user_Service;
	
	//This is PostMethod for Save User Record in database.
	@PostMapping("/register")
	public ResponseEntity<User> saveUser(@Valid @RequestBody UserDTO userDTO){
		
		User user = new User();
		
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setMobileNo(userDTO.getMobileNo());
		user.setPassword(userDTO.getPassword());
	
		User saveUser = user_Service.saveUser(user);
		
		return new ResponseEntity<>(saveUser,HttpStatus.OK);
		
	}
}
//	
//	//this method for get user user list 
//	@GetMapping("/getUser")
//	public ResponseEntity<List<User>> getAllUser(){
//		
//		List<User> user = user_Service.getAllUser();
//		
//		if(user==null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		
//		return new ResponseEntity<>(user,HttpStatus.FOUND);
//	}
//	
//	//this getmapping method create for get user data using id
//	@GetMapping("/{id}")
//	public ResponseEntity<User> getUserRecordById(@PathVariable("id") int id, @RequestBody UserDTO userDTO){
//		
//		User user = user_Service.getUserById(id);
//		
//		if(user==null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			
//		}
//		return new ResponseEntity<>(user,HttpStatus.FOUND);
//	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody UserDTO userDTO){
//		
//		User user = user_Service.getUserById(id);
//		
//		if(user==null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		
//		user.setName(userDTO.getName());
//		user.setEmail(userDTO.getEmail());
//		user.setMobileNo(userDTO.getMobileNo());
//		user.setPassword(userDTO.getPassword());
//		
//		User saveUser = user_Service.saveUser(user);
//		
//		return new ResponseEntity<>(saveUser,HttpStatus.OK);
//	}
//}
