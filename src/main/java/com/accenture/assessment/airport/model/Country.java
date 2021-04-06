package com.accenture.assessment.airport.model;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Country")
public class Country {
    @Id
    @CsvBindByName
    private String code;

    @CsvBindByName
    private Long id;

    @Column
    @CsvBindByName
    private String name;

    @Column
    @CsvBindByName
    private String continent;

    @Column(name = "wikipedia_link")
    @CsvBindByName(column = "wikipedia_link")
    private String wikipediaLink;

    @Column
    @CsvBindByName
    private String keywords;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "iso_country")
    private List<Airport> airports = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
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

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    /*@Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", wikipediaLink='" + wikipediaLink + '\'' +
                ", keywords='" + keywords + '\'' +
                ", airports=" + airports +
                '}';
    }*/
}
