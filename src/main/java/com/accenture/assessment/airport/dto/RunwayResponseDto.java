package com.accenture.assessment.airport.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class RunwayResponseDto {

  private String countryName;
  private String countryCode;
  @JsonProperty(value = "Airports")
  private List<AirportResponseDto> airportResponseDtos = new ArrayList<>();


}
