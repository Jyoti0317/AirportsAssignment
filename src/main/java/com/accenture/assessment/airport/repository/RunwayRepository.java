package com.accenture.assessment.airport.repository;

import com.accenture.assessment.airport.model.Runway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunwayRepository extends JpaRepository<Runway, Long> {


}
