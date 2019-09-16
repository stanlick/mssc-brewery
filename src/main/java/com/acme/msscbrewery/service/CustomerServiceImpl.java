package com.acme.msscbrewery.service;

import java.util.UUID;

import com.acme.msscbrewery.domain.BaseDto;
import com.acme.msscbrewery.domain.CustomerDto;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements AcmeService<CustomerDto> {

    @Override
    public CustomerDto getById(UUID id) {
        log.debug("Fetching customer {}", id);
        BaseDto baseDto = BaseDto.builder().id(UUID.randomUUID()).build();
        return CustomerDto.builder().baseDto(baseDto).fullName("J Scott Stanlick").email("stanlick@gmail.com").build();
    }

    @Override
    public CustomerDto save(CustomerDto dto) {
        log.debug("Creating customer {}", dto);
        BaseDto baseDto = BaseDto.builder().id(UUID.randomUUID()).build();
        return CustomerDto.builder().baseDto(baseDto).build();
    }

    @Override
    public CustomerDto update(UUID id, CustomerDto dto) {
        log.debug("Updating customer {}", id);
        return null;
    }

    @Override
    public CustomerDto deleteById(UUID id) {
        log.debug("Deleting customer {}", id);
        return null;
    }

}