package com.accenture.assessment.airport.service;

import com.accenture.assessment.airport.dto.CountryResponseDto;
import com.accenture.assessment.airport.dto.RunwayResponseDto;

import java.util.List;

public interface AirportService {

    List<RunwayResponseDto> getRunways(String country);

    List<CountryResponseDto> getTopCountriesWithHighestNoOfAirports(int count);
}
