package com.acme.msscbrewery.domain;

import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class BaseDto {
    private UUID id;
    private Integer version;
    private Long upc;

    private OffsetDateTime createdOn;
    private OffsetDateTime lastModifiedOn;
}