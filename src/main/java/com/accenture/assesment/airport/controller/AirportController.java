package com.accenture.assesment.airport.controller;

import com.accenture.assesment.airport.model.Airport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirportController {


    @GetMapping(path = "/airports")
    public ResponseEntity<List<Airport>> getAirports(String country) throws Exception {
        try {

            if (StringUtils.isEmpty(country)) {
                throw new Exception("Country name is required");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        return null;
    }

    @GetMapping(path = "/runways")
    public ResponseEntity<List<Airport>> getRunways(String country) throws Exception {
        try {

            if (StringUtils.isEmpty(country)) {
                throw new Exception("Country name is required");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        return null;
    }


}
