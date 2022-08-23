package com.viz.udemy.brewery201.brewery.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viz.udemy.brewery201.brewery.web.model.BeerDto;
import com.viz.udemy.brewery201.brewery.web.model.BeerStyleEnum;

@JsonTest
//@ActiveProfiles("kebab")
public class BaseTest {
	
	@Autowired
	ObjectMapper objectMapper;
	
	BeerDto getDto() {
		return BeerDto.builder().beerName("Visakh")
				.beerStyle(BeerStyleEnum.LAGER_BEER)
				.price(new BigDecimal("22.21"))
				.createdDate(OffsetDateTime.now())
				.build();
	}
	
	@Test
	void testSerializeDto() throws JsonProcessingException{
		BeerDto beerDto= getDto();
		String jsonString = objectMapper.writeValueAsString(beerDto);
		System.out.println(jsonString);
	}

}
