package com.accenture.assessment.airport.dto;

public class CountryDto {
    private String code;
    private Long id;
    private String name;
    private String continent;
    private String wikipediaLink;
    private String keywords;

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "iso_country")
    private final List<Airport> airports = new ArrayList<>();*/

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "CountryDto{" +
                "code='" + code + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", wikipediaLink='" + wikipediaLink + '\'' +
                ", keywords='" + keywords + '\'' +
                '}';
    }
}
