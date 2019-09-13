package com.acme.msscbrewery.service;

import java.util.UUID;

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
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Fat Tire").beerStyle(BeerStyle.Amber_Ale).build();
    }

    @Override
    public  BeerDto save(BeerDto dto) {
        log.debug("Creating beer {}", dto);
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public  BeerDto update(UUID  id, BeerDto dto) {
        log.debug("Updating beer {}", id);
        return null;
    }

    @Override
    public BeerDto deleteById(UUID id) {
        log.debug("Deleting beer {}", id);
        return null;
    }

}