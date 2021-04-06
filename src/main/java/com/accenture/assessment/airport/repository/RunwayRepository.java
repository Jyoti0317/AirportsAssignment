package com.accenture.assessment.airport.repository;

import com.accenture.assessment.airport.model.Runway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunwayRepository extends JpaRepository<Runway, Long> {



        //select r.* from runway r join airport a on r.airport_ref = a.id where a.iso_country =(select code from country where LOWER(name) like '%zimb%' or LOWER(code) like '%zimb%')




}
