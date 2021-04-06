package com.accenture.assessment.airport.model;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitudeDeg() {
        return latitudeDeg;
    }

    public void setLatitudeDeg(Double latitudeDeg) {
        this.latitudeDeg = latitudeDeg;
    }

    public Double getLongitudeDeg() {
        return longitudeDeg;
    }

    public void setLongitudeDeg(Double longitudeDeg) {
        this.longitudeDeg = longitudeDeg;
    }

    public Long getElevationFt() {
        return elevationFt;
    }

    public void setElevationFt(Long elevationFt) {
        this.elevationFt = elevationFt;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getIsoCountry() {
        return isoCountry;
    }

    public void setIsoCountry(String isoCountry) {
        this.isoCountry = isoCountry;
    }

    public String getIsoRegion() {
        return isoRegion;
    }

    public void setIsoRegion(String isoRegion) {
        this.isoRegion = isoRegion;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getScheduledService() {
        return scheduledService;
    }

    public void setScheduledService(String scheduledService) {
        this.scheduledService = scheduledService;
    }

    public String getGpsCode() {
        return gpsCode;
    }

    public void setGpsCode(String gpsCode) {
        this.gpsCode = gpsCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getLocalCode() {
        return localCode;
    }

    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    public String getHomeLink() {
        return homeLink;
    }

    public void setHomeLink(String homeLink) {
        this.homeLink = homeLink;
    }

    public String getWikipediaLink() {
        return wikipediaLink;
    }

    public void setWikipediaLink(String wikipediaLink) {
        this.wikipediaLink = wikipediaLink;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public List<Runway> getRunways() {
        return runways;
    }

    public void setRunways(List<Runway> runways) {
        this.runways = runways;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", ident='" + ident + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", latitudeDeg=" + latitudeDeg +
                ", longitudeDeg=" + longitudeDeg +
                ", elevationFt=" + elevationFt +
                ", continent='" + continent + '\'' +
                ", isoCountry='" + isoCountry + '\'' +
                ", isoRegion='" + isoRegion + '\'' +
                ", municipality='" + municipality + '\'' +
                ", scheduledService='" + scheduledService + '\'' +
                ", gpsCode='" + gpsCode + '\'' +
                ", iataCode='" + iataCode + '\'' +
                ", localCode='" + localCode + '\'' +
                ", homeLink='" + homeLink + '\'' +
                ", wikipediaLink='" + wikipediaLink + '\'' +
                ", keywords='" + keywords + '\'' +
                '}';
    }
}
