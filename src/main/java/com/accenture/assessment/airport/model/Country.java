package com.accenture.assessment.airport.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "iso_country")
    private List<Airport> airports = new ArrayList<>();

}
