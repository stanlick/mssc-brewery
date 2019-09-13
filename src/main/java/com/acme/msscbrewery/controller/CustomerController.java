package com.acme.msscbrewery.controller;

import java.net.URI;
import java.util.UUID;
import static com.acme.msscbrewery.controller.EndPoints.*;
import com.acme.msscbrewery.domain.CustomerDto;
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
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(API_V1_CUSTOMER)
public class CustomerController {

    private final AcmeService<CustomerDto> service;

    public CustomerController(AcmeService<CustomerDto> service) {
        this.service = service;
    }

    @GetMapping(API_V1_CUSTOMER_BY_ID)
    public ResponseEntity<CustomerDto> get(@PathVariable UUID id) {
        return new ResponseEntity<CustomerDto>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> save(UriComponentsBuilder uriComponentsBuilder, @RequestBody CustomerDto dto) {
        CustomerDto saved = service.save(dto);
        String expandedUri = UriUtils.expandUriAsString(uriComponentsBuilder) + "/" + saved.getId();
        return ResponseEntity.created(URI.create(expandedUri)).build();
    }

    @PutMapping(API_V1_CUSTOMER_BY_ID)
    public ResponseEntity<CustomerDto> update(@PathVariable UUID id, UriComponentsBuilder uriComponentsBuilder,
            @RequestBody CustomerDto dto) {
        service.update(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(API_V1_CUSTOMER_BY_ID)
    public ResponseEntity<CustomerDto> delete(@PathVariable UUID id) {
        return new ResponseEntity<CustomerDto>(service.deleteById(id), HttpStatus.OK);
    }
}