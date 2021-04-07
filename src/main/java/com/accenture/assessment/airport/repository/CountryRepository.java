package com.accenture.assessment.airport.repository;

import com.accenture.assessment.airport.model.Country;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query(value = "SELECT c, COUNT(a.id) as airportCount FROM Country c JOIN Airport a ON c.code = a.isoCountry\n" +
            "    GROUP BY c.code ORDER BY airportCount DESC")
    List<Country> findTopCountriesWithHighestNoOfAirports(Pageable page);

    List<Country> findByCodeContainsIgnoreCase(String countryCode);

    List<Country> findByNameContainsIgnoreCaseOrKeywordsContainsIgnoreCase(String countryName, String countryKeyword);

}
