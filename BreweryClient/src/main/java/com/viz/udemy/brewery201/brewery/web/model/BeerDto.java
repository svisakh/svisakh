package com.viz.udemy.brewery201.brewery.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
		
		@JsonProperty("beerId")
		private UUID id;
		
		private Integer version;
		
		@JsonFormat(pattern = "yyyy-MM-dd", shape =JsonFormat.Shape.STRING)
		private OffsetDateTime createdDate;
		private OffsetDateTime lastModifiedDate;
		private String beerName;
		private BeerStyleEnum beerStyle;
		private Long upc;
		
		@JsonFormat(shape = JsonFormat.Shape.STRING)
		private BigDecimal price;
		private Integer quantityOnHand;
}
