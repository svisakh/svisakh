package com.viz.udemy.brewery201.brewery.repostories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.viz.udemy.brewery201.brewery.domain.Beer;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
