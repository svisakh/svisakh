package com.viz.udemy.brewery201.brewery.web.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viz.udemy.brewery201.brewery.web.model.BeerDto;
import com.viz.udemy.brewery201.brewery.web.service.BeerService;

@WebMvcTest(BeerController.class)
public class BeerControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	private BeerService beerService;

	private static String urlTemplateStringBase = "/api/v1/beer/";
	
	@Test
	void getBeerById() throws Exception {
		
		BeerDto beerDto = BeerDto.builder().build();
		when(beerService.getBeerById(null)).thenReturn(beerDto);
		
		String urlTemplateString = urlTemplateStringBase + UUID.randomUUID().toString();
		mockMvc.perform(get(urlTemplateString).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		
	}
	
	/*
	 * @Test void saveNewBeer() throws Exception {
	 * 
	 * BeerDto beerDto =
	 * BeerDto.builder().id(UUID.randomUUID()).beerName("KingFisher").build();
	 * String beerDtoJson = objectMapper.writeValueAsString(beerDto);
	 * 
	 * when(beerService.saveNewBeer(beerDto)).thenReturn(beerDto);
	 * 
	 * mockMvc.perform(post(urlTemplateStringBase)
	 * .accept(MediaType.APPLICATION_JSON) .content(beerDtoJson))
	 * .andExpect(status().isCreated()); }
	 */

}
