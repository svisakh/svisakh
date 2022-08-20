package com.viz.udemy.brewery201.brewery.web.service;

import java.util.UUID;

import com.viz.udemy.brewery201.brewery.web.model.BeerDto;

public interface BeerService {
	BeerDto getBeerById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	BeerDto updateBeer(UUID beerId, BeerDto beerDto);

	BeerDto deleteBeerById(UUID beerId);
}
