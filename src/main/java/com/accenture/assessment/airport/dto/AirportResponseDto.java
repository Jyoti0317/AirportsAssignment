package com.accenture.assessment.airport.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AirportResponseDto {
    private String airportName;
    @JsonProperty(value = "Runways")
    private List<RunwayDto> runways;
}
