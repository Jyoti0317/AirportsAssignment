package com.accenture.assessment.airport.service;

import com.accenture.assessment.airport.dto.CountryDto;
import com.accenture.assessment.airport.dto.RunwayDto;

import java.util.List;

public interface AirportService {

    List<RunwayDto> getRunways(String country);

    List<CountryDto> getTopCountriesWithHighestNoOfAirports(int count);
}
