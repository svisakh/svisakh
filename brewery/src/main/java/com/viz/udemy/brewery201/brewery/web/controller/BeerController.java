package com.viz.udemy.brewery201.brewery.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.viz.udemy.brewery201.brewery.web.model.BeerDto;
import com.viz.udemy.brewery201.brewery.web.service.BeerService;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/v1/beer")
@RestController
@Validated
@Slf4j
public class BeerController {
	
	@Autowired
	BeerService beerService;
	
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeerById(@NotNull @PathVariable UUID beerId){
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity saveNewBeer(@Valid @NotNull @RequestBody BeerDto beerDto) {
		val savedDto = beerService.saveNewBeer(beerDto);
		val headers = new HttpHeaders();
		headers.add("Location",savedDto.getId().toString());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{beerId}")
	public void updateBeerById(@Valid @RequestBody BeerDto beerDto, @PathVariable("beerId")UUID  beerId) {
		BeerDto savedDto = beerService.updateBeer(beerId, beerDto);
		
	
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeerById(@PathVariable("beerId")UUID  beerId) {
		BeerDto savedDto = beerService.deleteBeerById(beerId);
	}
	
	
}
