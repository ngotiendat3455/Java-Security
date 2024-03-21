package com.eazybytes.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.demo.model.Customer;
import com.eazybytes.demo.reponsitory.CustomerReponsitory;

@RestController
public class LoginController {
	CustomerReponsitory customerReponsitory;
	PasswordEncoder passwordEncoder;
	public LoginController(CustomerReponsitory customerReponsitory, PasswordEncoder passwordEncoder) {
		this.customerReponsitory = customerReponsitory;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer){
		Customer savedCustomer = null;
		ResponseEntity response = null;
		
		try {
			String hashPwd = this.passwordEncoder.encode(customer.getPwd());
			customer.setPwd(hashPwd);
			savedCustomer = customerReponsitory.save(customer);
			response = ResponseEntity.status(HttpStatus.CREATED).body("Given user details are successfully registered");
		} catch (Exception ex) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occured due to" + ex.getMessage());
		}
		return response;
	}
	
}
