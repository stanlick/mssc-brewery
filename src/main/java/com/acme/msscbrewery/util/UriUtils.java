package com.acme.msscbrewery.util;

import java.net.URI;

import com.acme.msscbrewery.domain.BeerDto;
import com.acme.msscbrewery.domain.CustomerDto;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class UriUtils {

    public static URI expandUri(BeerDto dto){

        return ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(dto.getBaseDto().getId())
        .toUri();
    }

    public static URI expandUri(CustomerDto dto){

        return ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(dto.getBaseDto().getId())
        .toUri();
    }
}