package com.viz.udemy.brewery201.brewery.client;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.viz.udemy.brewery201.brewery.web.model.CustomerDto;

@SpringBootTest
@Disabled
public class CustomerClientTest {
	
	@Autowired
	CustomerClient customerClient;
	
	@Test
	void getCustomerById() {
		CustomerDto dto = customerClient.getCustomerdById(UUID.randomUUID());
		assertNotNull(dto);
	}
	
	@Test
	void testSaveNewCustomer() {
		CustomerDto CustomerDto = com.viz.udemy.brewery201.brewery.web.model.CustomerDto.builder().customerId(UUID.randomUUID()).customerName("New Customer").build();
		URI uri = customerClient.saveNewCustomer(CustomerDto);
		assertNotNull(uri);
		System.out.println(uri.toString());
	}
	
	@Test
	void testUpdateCustomer() {
		CustomerDto CustomerDto = com.viz.udemy.brewery201.brewery.web.model.CustomerDto.builder().customerName("New Customer").build();
		customerClient.updateCustomer(UUID.randomUUID(), CustomerDto);
		
		
	}
	
	@Test
	void deleteCustomer() {
		customerClient.deleteCustomer(UUID.randomUUID());
	}

}
