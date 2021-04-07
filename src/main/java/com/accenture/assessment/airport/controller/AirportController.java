package com.accenture.assessment.airport.controller;

import com.accenture.assessment.airport.dto.CountryResponseDto;
import com.accenture.assessment.airport.dto.RunwayResponseDto;
import com.accenture.assessment.airport.exception.ElementNotFoundException;
import com.accenture.assessment.airport.exception.BadRequestException;
import com.accenture.assessment.airport.service.AirportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    private static final Logger logger = LogManager.getLogger(AirportController.class);

    private static final int NO_OF_COUNTRIES = 10;

    @Autowired
    private AirportService airportService;


    @GetMapping(path = "/runways")
    public ResponseEntity<List<RunwayResponseDto>> getRunways(@RequestParam String countryName) {
        logger.info("Request initiated to get runways for country  " + countryName);
        try {
            List<RunwayResponseDto> runways = airportService.getRunways(countryName);
            return new ResponseEntity<List<RunwayResponseDto>>(runways, HttpStatus.OK);

        } catch (ElementNotFoundException ex) {
            throw ex;
        } catch (BadRequestException ex) {
            throw ex;
        }

    }

    @GetMapping(path = "/topcountries")
    public ResponseEntity<List<CountryResponseDto>> getTopCountriesWithHighestNoOfAirports() throws Exception {
        logger.info("Request received to find top countries with highest airports");
        try {
            List<CountryResponseDto> countries = airportService.getTopCountriesWithHighestNoOfAirports(NO_OF_COUNTRIES);
            return new ResponseEntity<List<CountryResponseDto>>(countries, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("Error occurred in getting countries with highest airport", ex.getMessage());
            ex.printStackTrace();
            throw new Exception("Error occurred in getting countries with highest airports");

        }


    }

    public void setAirportService(AirportService airportService) {
        this.airportService = airportService;
    }
}
