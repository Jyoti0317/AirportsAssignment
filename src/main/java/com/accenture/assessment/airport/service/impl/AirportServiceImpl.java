package com.accenture.assessment.airport.service.impl;

import com.accenture.assessment.airport.dto.AirportResponseDto;
import com.accenture.assessment.airport.dto.CountryResponseDto;
import com.accenture.assessment.airport.dto.RunwayDto;
import com.accenture.assessment.airport.dto.RunwayResponseDto;
import com.accenture.assessment.airport.exception.ElementNotFoundException;
import com.accenture.assessment.airport.model.Airport;
import com.accenture.assessment.airport.model.Country;
import com.accenture.assessment.airport.model.Runway;
import com.accenture.assessment.airport.repository.CountryRepository;
import com.accenture.assessment.airport.repository.RunwayRepository;
import com.accenture.assessment.airport.service.AirportService;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {

  private static final Logger logger = LogManager.getLogger(AirportServiceImpl.class);
  @Autowired
  private CountryRepository countryRepository;

  @Autowired
  private RunwayRepository runwayRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public List<RunwayResponseDto> getRunways(String countryName) {
    List<Country> countries;
    if (countryName.length() == 2) {
      logger.debug("Finding country by country code");
      countries = countryRepository.findByCodeContainsIgnoreCase(countryName);
    } else {
      logger.debug("Finding country by country name or keywords");
      countries = countryRepository
          .findByNameContainsIgnoreCaseOrKeywordsContainsIgnoreCase(countryName, countryName);
    }

    if (countries == null || countries.isEmpty()) {
      logger.error("No country found with given name or code " + countryName);
      throw new ElementNotFoundException("Country with name " + countryName + " not found");
    }
    List<RunwayResponseDto> runwayResponse = countries.stream().map(this::createRunwayResponse)
        .collect(Collectors.toList());
    logger.debug("Total countries found " + runwayResponse.size());
    return runwayResponse;
  }

  @Override
  public List<CountryResponseDto> getTopCountriesWithHighestNoOfAirports(int count) {
    logger.debug("Finding top " + count + " countries from database.");
    List<Country> countries = countryRepository
        .findTopCountriesWithHighestNoOfAirports(PageRequest.of(0, count));
    logger.debug(
        "Country list got from database with size " + countries.size());
    return countries.stream().map(this::convertToDto)
        .collect(Collectors.toList());
  }

  private RunwayResponseDto createRunwayResponse(Country country) {
    RunwayResponseDto runwayResponseDto = new RunwayResponseDto();
    runwayResponseDto.setCountryName(country.getName());
    runwayResponseDto.setCountryCode(country.getCode());
    List<AirportResponseDto> airportResponseDtos = country.getAirports().stream()
        .map(this::createAirportResponseDto).collect(Collectors.toList());
    runwayResponseDto.setAirportResponseDtos(airportResponseDtos);
    return runwayResponseDto;
  }

  private AirportResponseDto createAirportResponseDto(Airport airport) {
    AirportResponseDto airportResponseDto = new AirportResponseDto();
    airportResponseDto.setAirportName(airport.getName());
    airportResponseDto.setRunways(
        airport.getRunways().stream().map(this::convertToDto).collect(Collectors.toList()));
    return airportResponseDto;
  }

  private RunwayDto convertToDto(Runway runway) {
    return modelMapper.map(runway, RunwayDto.class);
  }

  private CountryResponseDto convertToDto(Country country) {
    CountryResponseDto countryResponseDto = modelMapper.map(country, CountryResponseDto.class);
    countryResponseDto.setAirportCount(country.getAirports().size());
    return countryResponseDto;
  }

  public void setCountryRepository(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }
}
