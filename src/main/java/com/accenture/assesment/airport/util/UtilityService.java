package com.accenture.assesment.airport.util;

import com.accenture.assesment.airport.model.Airport;
import com.accenture.assesment.airport.model.Country;
import com.accenture.assesment.airport.model.Runway;
import com.accenture.assesment.airport.repository.AirportRepository;
import com.accenture.assesment.airport.repository.CountryRepository;
import com.accenture.assesment.airport.repository.RunwayRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

@Component
public class UtilityService {


    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RunwayRepository runwayRepository;


    @PostConstruct
    public void populateCSVToDatabase() throws FileNotFoundException, URISyntaxException {
        URL airportResource = UtilityService.class.getClassLoader().getResource("files/airports.csv");
        File file = Paths.get(airportResource.toURI()).toFile();

        List<Airport> airports = new CsvToBeanBuilder(new FileReader(file))
                .withType(Airport.class)
                .build()
                .parse();

        URL countryResource = UtilityService.class.getClassLoader().getResource("files/countries.csv");
        file = Paths.get(countryResource.toURI()).toFile();

        List<Country> countries = new CsvToBeanBuilder(new FileReader(file))
                .withType(Country.class)
                .build()
                .parse();


        URL runwayResource = UtilityService.class.getClassLoader().getResource("files/runways.csv");
        file = Paths.get(runwayResource.toURI()).toFile();

        List<Runway> runways = new CsvToBeanBuilder(new FileReader(file))
                .withType(Runway.class)
                .build()
                .parse();

        if (airports.size() > 0) {
            airportRepository.saveAll(airports);
        }

        if (countries.size() > 0) {
            countryRepository.saveAll(countries);
        }

        if (runways.size() > 0) {
            runwayRepository.saveAll(runways);
        }


    }

}
