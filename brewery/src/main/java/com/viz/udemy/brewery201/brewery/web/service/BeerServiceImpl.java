package com.viz.udemy.brewery201.brewery.web.service;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import com.viz.udemy.brewery201.brewery.web.model.BeerDto;
import com.viz.udemy.brewery201.brewery.web.model.BeerStyleEnum;

@Service
public class BeerServiceImpl implements BeerService {

	
	public BeerDto getBeerById(UUID beerId) {
		// TODO Auto-generated method stub
		return BeerDto.builder().id(UUID.randomUUID()).beerName("Galaxy Cat")
				.beerStyle("LAGER_BEER")
				.build();
	}
	
	public BeerDto saveNewBeer(BeerDto beerDto) {
		

		
		
		return BeerDto.builder().id(UUID.randomUUID()).build();
		
	}
	
	public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
		return BeerDto.builder().id(UUID.randomUUID()).build();
	}
	
	public BeerDto deleteBeerById(UUID beerId) {
		return BeerDto.builder().id(UUID.randomUUID()).build();
	}

}
