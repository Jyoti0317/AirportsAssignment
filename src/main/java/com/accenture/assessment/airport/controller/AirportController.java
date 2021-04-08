package com.accenture.assessment.airport.controller;

import com.accenture.assessment.airport.dto.CountryResponseDto;
import com.accenture.assessment.airport.dto.RunwayResponseDto;
import com.accenture.assessment.airport.exception.ElementNotFoundException;
import com.accenture.assessment.airport.service.AirportService;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airport")
public class AirportController {

  private static final Logger logger = LogManager.getLogger(AirportController.class);

  private static final int NO_OF_COUNTRIES = 10;

  @Autowired
  private AirportService airportService;


  @GetMapping(path = "/runways")
  public ResponseEntity<List<RunwayResponseDto>> getRunways(@RequestParam String countryName) {
    logger.debug("Request initiated to get runways for country  " + countryName);
    List<RunwayResponseDto> runways = airportService.getRunways(countryName);
    logger.debug("Returning Runway records ");
    return new ResponseEntity<>(runways, HttpStatus.OK);
  }

  @GetMapping(path = "/countries/top")
  public ResponseEntity<List<CountryResponseDto>> getTopCountriesWithHighestNoOfAirports()
      throws Exception {
    logger.info("Request received to find top countries with highest airports");
    List<CountryResponseDto> countries = airportService
        .getTopCountriesWithHighestNoOfAirports(NO_OF_COUNTRIES);
    if (countries.isEmpty()) {
      logger.error("No data available in the database");
      throw new ElementNotFoundException("No data available in database");
    }

    return new ResponseEntity<>(countries, HttpStatus.OK);

  }

  public void setAirportService(AirportService airportService) {
    this.airportService = airportService;
  }
}
