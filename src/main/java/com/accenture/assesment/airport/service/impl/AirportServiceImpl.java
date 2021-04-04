package com.accenture.assesment.airport.service.impl;

import com.accenture.assesment.airport.model.Airport;
import com.accenture.assesment.airport.model.Runway;
import com.accenture.assesment.airport.service.AirportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {
    @Override
    public List<Airport> getAirports(String country) {
        return null;
    }

    @Override
    public List<Runway> getRunways(String country) {
        return null;
    }

}
