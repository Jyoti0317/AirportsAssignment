package com.accenture.assessment.airport.controller;

import com.accenture.assessment.airport.dto.CountryDto;
import com.accenture.assessment.airport.dto.RunwayDto;
import com.accenture.assessment.airport.service.AirportService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    private static final Logger logger = LogManager.getLogger(AirportController.class);

    @Autowired
    private AirportService airportService;


    @GetMapping(path = "/runways/{country}")
    public ResponseEntity<List<RunwayDto>> getRunways(@PathVariable String country) throws Exception {
        logger.info("Request initiated to get runways for country  " + country);
        try {

            if (StringUtils.isEmpty(country)) {
                throw new Exception("Country Name or Country Code  is required");
            }

            List<RunwayDto> runways = airportService.getRunways(country);
            return new ResponseEntity<List<RunwayDto>>(runways, HttpStatus.OK);

        } catch (Exception ex) {
            logger.error("Error occurred while getting runways for country", ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }

    }

    @GetMapping(path = "/topcountries/{count}")
    public ResponseEntity<List<CountryDto>> getTopCountriesWithHighestNoOfAirports(@PathVariable int count) throws Exception {
        logger.info("Request received to find top " + count + " countries with highest airports");
        try {
            if (count == 0) {
                logger.info("Provided count is 0. Finding top 10 countries with highest airport");
                count = 10;
            }
            List<CountryDto> countries = airportService.getTopCountriesWithHighestNoOfAirports(count);
            return new ResponseEntity<List<CountryDto>>(countries, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("Error occurred in getting countries with highest airport", ex.getMessage());
            ex.printStackTrace();
            throw new Exception("Error occurred in getting countries with highest airport");

        }


    }

}
