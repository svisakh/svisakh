package com.viz.udemy.brewery201.brewery.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.viz.udemy.brewery201.brewery.web.model.CustomerDto;


public interface CustomerService {
	CustomerDto getCustomerById(UUID customerId);

	CustomerDto saveNewCustomer(CustomerDto customerDto);

	CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto);

	CustomerDto deleteCustomerById(UUID customerId);
}
