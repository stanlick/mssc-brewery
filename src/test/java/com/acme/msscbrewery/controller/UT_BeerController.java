package com.acme.msscbrewery.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import com.acme.msscbrewery.domain.BaseDto;
import com.acme.msscbrewery.domain.BeerDto;
import com.acme.msscbrewery.domain.BeerStyle;
import com.acme.msscbrewery.service.AcmeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(BeerController.class)
public class UT_BeerController {

    @MockBean
    AcmeService<BeerDto> beerService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    BeerDto validBeer;

    @BeforeEach
    public void setup() {
        BaseDto baseDto = BaseDto.builder().id(UUID.randomUUID()).upc(123456789012L).build();
        validBeer = BeerDto.builder()
                            .baseDto(baseDto)
                            .beerName("Beer1")
                            .beerStyle(BeerStyle.Pale_Ale)                            
                            .build();
    }

    @Test
    public void getBeer() throws Exception{
    given(beerService.getById(any(UUID.class))).willReturn(validBeer);

        mockMvc.perform(get("/api/v1/beer/{id}", UUID.randomUUID())
               .accept(MediaType.APPLICATION_JSON))
               .andExpect( status().isOk() )
               .andExpect( content().contentType("application/json;charset=UTF-8") )
               .andExpect(   jsonPath("$.baseDto.id").value(validBeer.getBaseDto().getId().toString())  )
               .andExpect(jsonPath("$.beerName").value("Beer1"));
    }

    @Test
    public void saveNewBeer() throws Exception{
    given(beerService.save(any(BeerDto.class))).willReturn(validBeer);

    String beerDtoJson = objectMapper.writeValueAsString(validBeer);
        mockMvc.perform(post("/api/v1/beer")
               .contentType(MediaType.APPLICATION_JSON)
               .content(beerDtoJson))
               .andExpect( status().isCreated());
    }

    @Test
    public void updateBeer() throws Exception{
    given(beerService.update(any(UUID.class),any(BeerDto.class))).willReturn(validBeer);

    String beerDtoJson = objectMapper.writeValueAsString(validBeer);
        mockMvc.perform(put("/api/v1/beer/{id}", UUID.randomUUID())
               .contentType(MediaType.APPLICATION_JSON)
               .content(beerDtoJson))
               .andExpect( status().isNoContent());
    }
}