package com.acme.msscbrewery.service;

import java.time.OffsetDateTime;
import java.util.Random;
import java.util.UUID;

import com.acme.msscbrewery.domain.BaseDto;
import com.acme.msscbrewery.domain.BeerDto;
import com.acme.msscbrewery.domain.BeerStyle;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BeerServiceImpl implements AcmeService<BeerDto> {

    @Override
    public BeerDto getById(UUID id) {
        log.debug("Fetching beer {}", id);
        BaseDto baseDto = BaseDto.builder().id(UUID.randomUUID()).build();
        return BeerDto.builder().baseDto(baseDto).beerName("Fat Tire").beerStyle(BeerStyle.Amber_Ale).build();
    }

    @Override
    public  BeerDto save(BeerDto dto) {
        log.debug("Creating beer {}", dto);
        dto.getBaseDto().setId(UUID.randomUUID());
        dto.getBaseDto().setUpc(new Random().nextLong());
        dto.getBaseDto().setCreatedOn(OffsetDateTime.now());
        return dto;
    }

    @Override
    public  BeerDto update(UUID  id, BeerDto dto) {
        log.debug("Updating beer {}", id);
        dto.getBaseDto().setLastModifiedOn(OffsetDateTime.now());
        return null;
    }

    @Override
    public BeerDto deleteById(UUID id) {
        log.debug("Deleting beer {}", id);
        return null;
    }

}