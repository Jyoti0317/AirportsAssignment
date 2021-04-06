package com.accenture.assessment.airport.repository;

import com.accenture.assessment.airport.model.Country;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query(value = "SELECT c FROM Country c JOIN Airport a ON c.code = a.isoCountry\n" +
            "    GROUP BY c.code, c.id, c.continent, c.keywords, c.name, c.wikipediaLink ORDER BY COUNT(a.id) DESC")
    List<Country> findTopCountriesWithHighestNoOfAirports(Pageable page);

    List<Country> findByNameStartsWithIgnoreCaseOrCodeStartsWithIgnoreCase(String name, String code);

}
