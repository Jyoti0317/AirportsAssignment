package com.accenture.assessment.airport.service.impl;

import com.accenture.assessment.airport.dto.CountryDto;
import com.accenture.assessment.airport.dto.RunwayDto;
import com.accenture.assessment.airport.model.Country;
import com.accenture.assessment.airport.model.Runway;
import com.accenture.assessment.airport.repository.CountryRepository;
import com.accenture.assessment.airport.repository.RunwayRepository;
import com.accenture.assessment.airport.service.AirportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<RunwayDto> getRunways(String countryName) {
        List<Country> countries = countryRepository.findByNameStartsWithIgnoreCaseOrCodeStartsWithIgnoreCase(countryName, countryName);
        Country country = countries.get(0);
        logger.info("country " + country);
        List<Runway> runways = new ArrayList<>();
        List<RunwayDto> runwayDtos = new ArrayList<>();
        country.getAirports().forEach(a -> runways.addAll(a.getRunways()));
        runwayDtos = runways.stream().map(this::convertToDto).collect(Collectors.toList());
        logger.info("runways size " + runwayDtos.size());
        return runwayDtos;
    }

    @Override
    public List<CountryDto> getTopCountriesWithHighestNoOfAirports(int count) {
        logger.debug("Finding top " + count + " countries from database.");
        List<Country> countries = countryRepository.findTopCountriesWithHighestNoOfAirports(PageRequest.of(0, count));
        logger.debug("Country list got from database with size " + countries != null ? countries.size() : 0);

        List<CountryDto> countryDtos = countries.stream().map(this::convertToDto).collect(Collectors.toList());

        return countryDtos;
    }

    private RunwayDto convertToDto(Runway runway) {
        RunwayDto runwayDto = modelMapper.map(runway, RunwayDto.class);
        return runwayDto;
    }

    private CountryDto convertToDto(Country country) {
        CountryDto countryDto = modelMapper.map(country, CountryDto.class);
        return countryDto;
    }

}
