package com.accenture.assessment.airport.controller;

import com.accenture.assessment.airport.dto.CountryResponseDto;
import com.accenture.assessment.airport.dto.RunwayResponseDto;
import com.accenture.assessment.airport.exception.BadRequestException;
import com.accenture.assessment.airport.exception.ElementNotFoundException;
import com.accenture.assessment.airport.service.AirportService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ActiveProfiles(value = "test")
@WebMvcTest(controllers = AirportController.class)
public class AirportControllerTest {

    private static final int NO_OF_COUNTRIES = 10;
    @Autowired
    WebApplicationContext webApplicationContext;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AirportService airportService;

    @BeforeEach
    protected void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetRunwaysForCountryCode() throws Exception {
        List<RunwayResponseDto> runways = new ArrayList<RunwayResponseDto>();
        when(airportService.getRunways("NL")).thenReturn(runways);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/airport/runways").queryParam("countryName", "NL");
        MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();
        Assertions.assertEquals(200, response.getStatus());

    }

    @Test
    public void testGetTopCountriesWithHighestNoOfAirports() throws Exception {
        List<CountryResponseDto> countries = new ArrayList<>();
        countries.add(new CountryResponseDto());
        when(airportService.getTopCountriesWithHighestNoOfAirports(anyInt())).thenReturn(countries);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/airport/topcountries");
        MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();
        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    public void testGetRunwaysBadRequestException() throws Exception {
        when(airportService.getRunways(anyString())).thenThrow(BadRequestException.class);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/airport/runways").queryParam("countryName", "N");
        MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();
        Assertions.assertEquals(400, response.getStatus());
    }


    @Test
    public void testGetRunwaysElementNotFoundException() throws Exception {
        when(airportService.getRunways(anyString())).thenThrow(ElementNotFoundException.class);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/airport/runways").queryParam("countryName", "ABC");
        MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();
        Assertions.assertEquals(404, response.getStatus());
    }
}
