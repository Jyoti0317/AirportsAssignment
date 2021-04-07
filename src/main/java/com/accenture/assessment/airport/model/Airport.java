package com.accenture.assessment.airport.model;

import com.opencsv.bean.CsvBindByName;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Airport")
public class Airport {

  @Id
  @CsvBindByName
  private Long id;

  @CsvBindByName
  @Column(name = "ident")
  private String ident;

  @CsvBindByName
  @Column(name = "type")
  private String type;

  @CsvBindByName
  @Column(name = "name")
  private String name;

  @CsvBindByName(column = "latitude_deg")
  @Column(name = "latitudeDeg")
  private Double latitudeDeg;

  @CsvBindByName(column = "longitude_deg")
  @Column(name = "longitudeDeg")
  private Double longitudeDeg;

  @CsvBindByName(column = "elevation_ft")
  @Column(name = "elevationFt")
  private Long elevationFt;

  @CsvBindByName
  @Column(name = "continent")
  private String continent;

  @CsvBindByName(column = "iso_country")
  @Column(name = "iso_country")
  private String isoCountry;

  @CsvBindByName(column = "iso_region")
  @Column(name = "iso_region")
  private String isoRegion;

  @CsvBindByName
  @Column(name = "municipality")
  private String municipality;

  @CsvBindByName(column = "scheduled_service")
  @Column(name = "scheduledService")
  private String scheduledService;

  @CsvBindByName(column = "gps_code")
  @Column(name = "gps_code")
  private String gpsCode;

  @CsvBindByName(column = "iata_code")
  @Column(name = "iataCode")
  private String iataCode;

  @CsvBindByName(column = "local_code")
  @Column(name = "localCode")
  private String localCode;

  @CsvBindByName(column = "home_link")
  @Column(name = "homeLink", length = 500)
  private String homeLink;

  @CsvBindByName(column = "wikipedia_link")
  @Column(name = "wikipediaLink", length = 500)
  private String wikipediaLink;

  @CsvBindByName(column = "keywords")
  @Column(name = "keywords", length = 500)
  private String keywords;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "airport_ref")
  private List<Runway> runways = new ArrayList<>();

}
