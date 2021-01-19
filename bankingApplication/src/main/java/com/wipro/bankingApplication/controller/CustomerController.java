package com.wipro.bankingApplication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bankingApplication.domain.Customer;
import com.wipro.bankingApplication.service.ICustomerService;
import com.wipro.bankingApplication.util.MyCustomErrorType;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/")
	public ResponseEntity<?> saveCustomerRecord(@Validated @RequestBody Customer theCustomer, BindingResult bindingResult ){
		
		  if(bindingResult.hasErrors()) { List<String> errors=
		  bindingResult.getFieldErrors().stream() .map(error ->{ return
		  "[Field: "+error.getField()+", message: "+error.getDefaultMessage()+"]";
		  }).collect(Collectors.toList()); return
		  ResponseEntity.badRequest().body(errors); }
		 
		theCustomer = customerService.saveCustomerRecord(theCustomer);
		return ResponseEntity.ok(theCustomer);
		
	}
}
