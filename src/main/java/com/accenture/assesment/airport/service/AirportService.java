package com.accenture.assesment.airport.service;

import com.accenture.assesment.airport.model.Airport;
import com.accenture.assesment.airport.model.Runway;

import java.util.List;

public interface AirportService {
    List<Airport> getAirports(String country);

    List<Runway> getRunways(String country);
}
