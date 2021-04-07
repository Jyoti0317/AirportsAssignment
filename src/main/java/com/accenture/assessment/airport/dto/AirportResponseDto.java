package com.accenture.assessment.airport.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class AirportResponseDto {

  private String airportName;
  @JsonProperty(value = "Runways")
  private List<RunwayDto> runways;
}
