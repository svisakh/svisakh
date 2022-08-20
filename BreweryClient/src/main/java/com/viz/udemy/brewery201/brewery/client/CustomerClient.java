package com.viz.udemy.brewery201.brewery.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.viz.udemy.brewery201.brewery.web.model.CustomerDto;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class CustomerClient {
	
	public final String Customer_PATH_V1="/api/v1/customer/";
	private String apihost;
	private final RestTemplate restTemplate;
	
	public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
		restTemplate = restTemplateBuilder.build();
	}
	
	public CustomerDto getCustomerdById(UUID uuid) {
		return restTemplate.getForObject(apihost + Customer_PATH_V1 + uuid.toString(), CustomerDto.class);
	}

	public String getApihost() {
		return apihost;
	}

	public void setApihost(String apihost) {
		this.apihost = apihost;
	}
	
	public URI saveNewCustomer(CustomerDto CustomerDto) {
		return restTemplate.postForLocation(apihost + Customer_PATH_V1, CustomerDto);
		
	}
	
	public void updateCustomer(UUID uuid, CustomerDto CustomerDto) {
		restTemplate.put(apihost + Customer_PATH_V1 + uuid.toString(), CustomerDto);
		
	}
	
	public void deleteCustomer(UUID uuid) {
		restTemplate.delete(apihost + Customer_PATH_V1 + uuid.toString());
		
	}

}
