package com.viz.udemy.brewery201.brewery.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viz.udemy.brewery201.brewery.web.model.CustomerDto;
import com.viz.udemy.brewery201.brewery.web.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId){
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity handlePost(@Validated @RequestBody CustomerDto customerDto) {
		CustomerDto savedDto = customerService.saveNewCustomer(customerDto);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Location",savedDto.getCustomerId().toString());
		
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{customerId}")
	public void handlePost(@Validated @RequestBody CustomerDto customerDto, @PathVariable("customerId")UUID  customerId) {
		CustomerDto savedDto = customerService.updateCustomer(customerId, customerDto);
		
	
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletecustomer(@PathVariable("customerId")UUID  customerId) {
		CustomerDto savedDto = customerService.deleteCustomerById(customerId);
	}
}
