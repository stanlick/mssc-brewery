package com.acme.msscbrewery.controller;

import static com.acme.msscbrewery.controller.EndPoints.API_V1_BEER;
import static com.acme.msscbrewery.controller.EndPoints.API_V1_BEER_BY_ID;

import java.util.UUID;

import com.acme.msscbrewery.domain.BeerDto;
import com.acme.msscbrewery.service.AcmeService;
import com.acme.msscbrewery.util.UriUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(API_V1_BEER)
public class BeerController {

    private final AcmeService<BeerDto> service;

    public BeerController(AcmeService<BeerDto> beerService) {
        this.service = beerService;
    }

    @GetMapping(API_V1_BEER_BY_ID)
    public ResponseEntity<BeerDto> get(@PathVariable UUID id) {
        return new ResponseEntity<BeerDto>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> save(@RequestBody BeerDto dto) {
        BeerDto saved = service.save(dto);
        return ResponseEntity.created(UriUtils.expandUri(saved)).build();
    }

    @PutMapping(API_V1_BEER_BY_ID)
    public ResponseEntity<BeerDto> update(@PathVariable UUID id, UriComponentsBuilder uriComponentsBuilder,
            @RequestBody BeerDto dto) {
        service.update(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(API_V1_BEER_BY_ID)
    public ResponseEntity<BeerDto> delete(@PathVariable UUID id) {
        return new ResponseEntity<BeerDto>(service.deleteById(id), HttpStatus.OK);
    }
}