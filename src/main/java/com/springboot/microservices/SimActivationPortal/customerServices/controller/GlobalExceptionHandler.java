package com.springboot.microservices.SimActivationPortal.customerServices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@EnableWebMvc
public class GlobalExceptionHandler {
	


	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> customerValidation(MethodArgumentNotValidException e){
		Map<String,String> rep = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String msg = error.getDefaultMessage();
			rep.put(fieldName,msg);
		});
		return new ResponseEntity<Map<String,String>>(rep, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> customerValidation1(HttpMessageNotReadableException e){

		ErrorMessage errorMessage = new ErrorMessage(new Date(),"Validation error",e.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

}
