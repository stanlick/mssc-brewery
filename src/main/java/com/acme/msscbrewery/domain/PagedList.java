package com.acme.msscbrewery.domain;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class PagedList extends PageImpl<BeerDto> {

    private static final long serialVersionUID = 1L;

    public PagedList(List<BeerDto> content) {
        super(content);
    }

    public PagedList(List<BeerDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }
    
    
    
}