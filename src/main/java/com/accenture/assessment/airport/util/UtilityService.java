package com.accenture.assessment.airport.util;

import com.accenture.assessment.airport.model.Airport;
import com.accenture.assessment.airport.model.Country;
import com.accenture.assessment.airport.model.Runway;
import com.accenture.assessment.airport.repository.AirportRepository;
import com.accenture.assessment.airport.repository.CountryRepository;
import com.accenture.assessment.airport.repository.RunwayRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(UtilityService.class);

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RunwayRepository runwayRepository;


    private File getFile(String fileName) throws URISyntaxException {
        URL countryResource = UtilityService.class.getClassLoader().getResource("files/" + fileName);
        File file = Paths.get(countryResource.toURI()).toFile();
        return file;
    }


    @PostConstruct
    public void populateCSVToDatabase() throws FileNotFoundException, URISyntaxException {
        logger.info("Loading csv files to database initiated");

        List<Country> countries = new CsvToBeanBuilder(new FileReader(getFile("countries.csv")))
                .withType(Country.class)
                .build()
                .parse();

        if (countries.size() > 0) {
            countryRepository.saveAll(countries);
        }


        List<Airport> airports = new CsvToBeanBuilder(new FileReader(getFile("airports.csv")))
                .withType(Airport.class)
                .build()
                .parse();


        if (airports.size() > 0) {
            airportRepository.saveAll(airports);
        }


        List<Runway> runways = new CsvToBeanBuilder(new FileReader(getFile("runways.csv")))
                .withType(Runway.class)
                .build()
                .parse();


        if (runways.size() > 0) {
            runwayRepository.saveAll(runways);
        }


        logger.info("Loading of csv files data to database is completed");
    }

}
