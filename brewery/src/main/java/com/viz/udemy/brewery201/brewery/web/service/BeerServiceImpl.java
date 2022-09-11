package com.viz.udemy.brewery201.brewery.web.service;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.viz.udemy.brewery201.brewery.domain.Beer;
import com.viz.udemy.brewery201.brewery.repostories.BeerRepository;
import com.viz.udemy.brewery201.brewery.web.exception.NotFoundException;
import com.viz.udemy.brewery201.brewery.web.mappers.BeerMapper;
import com.viz.udemy.brewery201.brewery.web.model.BeerDto;
import com.viz.udemy.brewery201.brewery.web.model.BeerStyleEnum;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BeerServiceImpl implements BeerService {
	
	private final BeerRepository  beerRepository;
	private final BeerMapper beerMapper;

	
	public BeerDto getBeerById(UUID beerId){
		// TODO Auto-generated method stub
		/*
		 * return BeerDto.builder().id(UUID.randomUUID()).beerName("Galaxy Cat")
		 * .beerStyle("LAGER_BEER") .build();
		 */
		
		return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
	}
	
	public BeerDto saveNewBeer(BeerDto beerDto) {
		
		//return BeerDto.builder().id(UUID.randomUUID()).build();
		
		return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
	}
	
	public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
		//return BeerDto.builder().id(UUID.randomUUID()).build();
	
		Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
		beer.setBeerName(beerDto.getBeerName());
		beer.setBeerStyle(beerDto.getBeerStyle());
		beer.setPrice(beerDto.getPrice());
		beer.setUpc(beerDto.getUpc());
		
		return beerMapper.beerToBeerDto(beerRepository.save(beer));
	}
	
	public BeerDto deleteBeerById(UUID beerId) {
		//return BeerDto.builder().id(UUID.randomUUID()).build();
		beerMapper.beerToBeerDto(beerRepository.deleteById(beerId));
		return null;
	}
}