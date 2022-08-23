package com.viz.udemy.brewery201.brewery.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.viz.udemy.brewery201.brewery.domain.Beer;
import com.viz.udemy.brewery201.brewery.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
	
	
	BeerDto beerToBeerDto(Beer beer) ;
	

	Beer beerDtoToBeer(BeerDto dto);
}
