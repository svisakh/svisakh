package com.viz.udemy.brewery201.brewery.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
		
		@Null
		private UUID id;
		
		@Null
		private Integer version;
		
		@Null
		@JsonFormat(pattern="yyyy-MM-dd", shape=JsonFormat.Shape.STRING)
		private OffsetDateTime createdDate;
		
		@Null
		@JsonFormat(pattern="yyyy-MM-dd", shape=JsonFormat.Shape.STRING)
		private OffsetDateTime lastModifiedDate;
		
		@NotBlank
		@Size(min =3, max = 100)
		private String beerName;
		
		@NotBlank
		private String beerStyle;
		
		@Positive
		@NotNull
		private Long upc;
		
		@NotNull
		@JsonFormat(shape=JsonFormat.Shape.STRING)
		private BigDecimal price;
		private Integer quantityOnHand;
}
