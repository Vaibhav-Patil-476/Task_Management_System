package com.Task_Management_System.ExceptionHandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Task_Management_System.Response.ErrorResponce;



@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handlevalidationException(MethodArgumentNotValidException ex) {
		Map<String, String> error = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(errors -> error.put(errors.getField(), errors.getDefaultMessage()));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponce> handleDublicate_Exception(ResourceNotFoundException ex) {

		ErrorResponce error = new ErrorResponce(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	// This method handle database exception
		@ExceptionHandler(DuplicateException.class)
		public ResponseEntity<ErrorResponce> handleDatabaseException(DuplicateException ex) {
			ErrorResponce error = new ErrorResponce(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
			return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// This method id Default PreDefine Exception
		@ExceptionHandler(Exception.class)
		public ResponseEntity<ErrorResponce> handlexception(Exception ex) {
			ErrorResponce error = new ErrorResponce(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Something Wents Wrong....!");
			return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

		}


}