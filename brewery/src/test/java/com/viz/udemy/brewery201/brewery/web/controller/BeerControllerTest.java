package com.viz.udemy.brewery201.brewery.web.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viz.udemy.brewery201.brewery.web.model.BeerDto;
import com.viz.udemy.brewery201.brewery.web.service.BeerService;

@AutoConfigureRestDocs(uriScheme = "https", uriHost = "localhost", uriPort = 80)
@WebMvcTest(BeerController.class)
@ExtendWith(RestDocumentationExtension.class)
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
		
		UUID randomUUID = UUID.randomUUID();

		BeerDto beerDto = BeerDto.builder().beerName("Visakh").beerStyle("Indian").id(randomUUID).build();
		when(beerService.getBeerById(randomUUID)).thenReturn(beerDto);

		//String urlTemplateString = urlTemplateStringBase + UUID.randomUUID().toString();
		mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/beer/{beerId}", randomUUID.toString())
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
				.andDo(MockMvcRestDocumentation.document("/api/v1/beer/",
						RequestDocumentation.pathParameters(RequestDocumentation.parameterWithName("beerId").description("UUID of desired beer")),
						PayloadDocumentation.relaxedResponseFields(PayloadDocumentation.fieldWithPath("id").description("id of beer"))
						));			
	}

	
	
	  @Test 
	  @Disabled
	  void saveNewBeer() throws Exception {
	  BeerDto beerDto =
	  BeerDto.builder().beerName("KingFisher").beerStyle("Indian").upc(5L).price(new BigDecimal("21.22")).build();
	  String beerDtoJson = objectMapper.writeValueAsString(beerDto);
	  
	  when(beerService.saveNewBeer(beerDto)).thenReturn(beerDto);
	  
	  mockMvc.perform(RestDocumentationRequestBuilders.post(urlTemplateStringBase)
			  .contentType(MediaType.APPLICATION_JSON)
	  .accept(MediaType.APPLICATION_JSON).content(beerDtoJson))
	  .andExpect(status().isCreated()); 
	  }
	  
	  @Test 	 
	  void updateBeer() throws Exception {
	  BeerDto beerDto =
	  BeerDto.builder().beerName("KingFisher").beerStyle("Indian").upc(5L).price(new BigDecimal("21.22")).build();
	  String beerDtoJson = objectMapper.writeValueAsString(beerDto);
	  
	  when(beerService.updateBeer(UUID.randomUUID(), beerDto)).thenReturn(beerDto);
	  
	  mockMvc.perform(RestDocumentationRequestBuilders.put(urlTemplateStringBase + UUID.randomUUID())
			  .contentType(MediaType.APPLICATION_JSON)
	  .accept(MediaType.APPLICATION_JSON).content(beerDtoJson))
	  .andExpect(status().isNoContent())
			  .andDo(MockMvcRestDocumentation.document("/api/v1/beer/",
					  PayloadDocumentation.requestFields(PayloadDocumentation.fieldWithPath("beerName").description("Name of the beer"),
					  PayloadDocumentation.fieldWithPath("id").ignored(),
					  PayloadDocumentation.fieldWithPath("createdDate").ignored(),
					  PayloadDocumentation.fieldWithPath("lastModifiedDate").ignored(),
					  PayloadDocumentation.fieldWithPath("beerStyle").description("Style of the beer"),
					  PayloadDocumentation.fieldWithPath("upc").ignored(),
					  PayloadDocumentation.fieldWithPath("price").ignored(),
					  PayloadDocumentation.fieldWithPath("quantityOnHand").ignored(),
					  PayloadDocumentation.fieldWithPath("version").ignored()
							  
					  ))); 
	  }
	 
	  
	 
}
