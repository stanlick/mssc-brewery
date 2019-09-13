package com.acme.msscbrewery.domain;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BeerDto{
    
private UUID id;
private Integer version;

private OffsetDateTime createdOn;
private OffsetDateTime lastModifiedOn;


private String beerName;
private BeerStyle beerStyle;

private BigDecimal price;

private Integer quantityOnHand;

private Long upc;


}