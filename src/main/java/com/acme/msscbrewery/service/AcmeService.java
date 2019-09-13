package com.acme.msscbrewery.service;

import java.util.UUID;

public interface AcmeService<T> {

	T getById(UUID Id);

	T save(T  dto);

	T update(UUID id, T dto);

	T deleteById(UUID id);
    
}