package com.viz.udemy.brewery201.brewery.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.viz.udemy.brewery201.brewery.domain.Beer;
import com.viz.udemy.brewery201.brewery.repostories.BeerRepository;

@Component
public class BeerLoader implements CommandLineRunner {
	
	private final BeerRepository beerRepistory;
	
	public BeerLoader(BeerRepository beerRepository) {
		this.beerRepistory = beerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		loadBeerObjects();
		System.out.println("Count of beers in DB is :" + beerRepistory.count());

	}

	private void loadBeerObjects() {
		if(beerRepistory.count() == 0) {
			beerRepistory.save(Beer.builder().beerName("KingFisher").beerStyle("Indian").price(new BigDecimal("12.95")).upc(1L).build());
			beerRepistory.save(Beer.builder().beerName("Heineken").beerStyle("German").price(new BigDecimal("11.95")).upc(2L).build());
		}
		
	}

}
