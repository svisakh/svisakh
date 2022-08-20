package com.viz.udemy.brewery201.brewery.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.viz.udemy.brewery201.brewery.web.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	
	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		// TODO Auto-generated method stub
		return CustomerDto.builder().customerId(UUID.randomUUID()).customerName("Visakh").build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		return CustomerDto.builder().customerId(UUID.randomUUID()).build();
	}

	@Override
	public CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		return CustomerDto.builder().customerId(UUID.randomUUID()).build();
	}

	@Override
	public CustomerDto deleteCustomerById(UUID customerId) {
		// TODO Auto-generated method stub
		return CustomerDto.builder().customerId(UUID.randomUUID()).build();
	}
}
