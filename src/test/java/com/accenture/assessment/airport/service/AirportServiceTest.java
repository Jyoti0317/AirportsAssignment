package com.accenture.assessment.airport.service;

import com.accenture.assessment.airport.dto.CountryResponseDto;
import com.accenture.assessment.airport.dto.RunwayResponseDto;
import com.accenture.assessment.airport.exception.ElementNotFoundException;
import com.accenture.assessment.airport.model.Airport;
import com.accenture.assessment.airport.model.Country;
import com.accenture.assessment.airport.model.Runway;
import com.accenture.assessment.airport.repository.CountryRepository;
import com.accenture.assessment.airport.service.impl.AirportServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AirportServiceTest {

  @Mock
  private CountryRepository countryRepository;

  @Autowired
  @InjectMocks
  private AirportServiceImpl airportService;


  @BeforeEach
  protected void setUp() {
    countryRepository = Mockito.spy(CountryRepository.class);
    airportService.setCountryRepository(countryRepository);
  }

  @Test
  public void testGetRunwaysByCountryCode() {
    Mockito.lenient().when(countryRepository.findByCodeContainsIgnoreCase("NL"))
        .thenReturn(getCountry());
    List<RunwayResponseDto> runwayResponseDtos = airportService.getRunways("NL");
    RunwayResponseDto runwayResponse = runwayResponseDtos.get(0);
    Assertions.assertEquals(1, runwayResponseDtos.size());
    Assertions.assertEquals("NL", runwayResponse.getCountryCode());
    Assertions.assertNotNull(runwayResponse.getAirportResponseDtos().get(0).getRunways());

  }

  @Test
  public void testGetTopCountriesWithHighestNoOfAirports() {
    Mockito.lenient()
        .when(countryRepository.findTopCountriesWithHighestNoOfAirports(PageRequest.of(0, 2)))
        .thenReturn(getTopCountries());
    List<CountryResponseDto> countryResponseDtos = airportService
        .getTopCountriesWithHighestNoOfAirports(2);
    Assertions.assertNotNull(countryResponseDtos);
    Assertions.assertEquals(2, countryResponseDtos.size());
    Assertions.assertEquals(2, countryResponseDtos.get(0).getAirportCount());
  }


  @Test
  public void testGetRunwaysElementNotFoundException() {
    Mockito.lenient().when(
        countryRepository.findByNameContainsIgnoreCaseOrKeywordsContainsIgnoreCase("ABC", "ABC"))
        .thenReturn(new ArrayList<>());
    try {

      List<RunwayResponseDto> runwayResponseDtos = airportService.getRunways("ABC");

    } catch (ElementNotFoundException ex) {
      Assertions.assertTrue(ex.getMessage().contains("not found"));
    }
  }

  private List<Country> getCountry() {
    List<Country> countries = new ArrayList<>();
    Country country = new Country();
    country.setCode("NL");
    country.setName("Netherlands");
    Airport airport = new Airport();
    Runway runway = new Runway();
    airport.getRunways().add(runway);
    country.getAirports().add(airport);
    countries.add(country);
    return countries;
  }

  private List<Country> getTopCountries() {
    List<Country> countries = new ArrayList<>();
    countries.addAll(getCountry());
    countries.addAll(getCountry());
    Airport airport1 = new Airport();
    countries.get(0).getAirports().add(airport1);
    return countries;
  }

}
