package com.accenture.assessment.airport.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CountryResponseDto {
    private String code;
    private Long id;
    private String name;
    private String continent;
    private String wikipediaLink;
    private String keywords;
    private int airportCount;

}
