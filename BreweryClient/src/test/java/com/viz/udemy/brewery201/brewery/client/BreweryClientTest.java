package com.viz.udemy.brewery201.brewery.client;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.viz.udemy.brewery201.brewery.web.model.BeerDto;

@Disabled
@SpringBootTest
public class BreweryClientTest {
	
	@Autowired
	BreweryClient breweryClient;
	
	@Test
	void getBeerById() {
		BeerDto dto = breweryClient.getBeerdById(UUID.randomUUID());
		assertNotNull(dto);
	}
	
	@Test
	void testSaveNewBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		URI uri = breweryClient.saveNewBeer(beerDto);
		assertNotNull(uri);
		System.out.println(uri.toString());
	}
	
	@Test
	void testUpdateBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		breweryClient.updateBeer(UUID.randomUUID(), beerDto);
		
		
	}
	
	@Test
	void deleteBeer() {
		breweryClient.deleteBeer(UUID.randomUUID());
	}

}
