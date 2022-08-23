package com.viz.udemy.brewery201.brewery.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.viz.udemy.brewery201.brewery.domain.Customer;
import com.viz.udemy.brewery201.brewery.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {
	

	CustomerDto customerToCustomerDto(Customer customer) ;
	

	Customer customerDtoToCustomer(CustomerDto dto);
}
