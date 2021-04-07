package com.accenture.assessment.airport.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "Runway")
@Entity
public class Runway {

    @Id
    @CsvBindByName
    private Long id;

    @Column(name = "airport_ref")
    @CsvBindByName(column = "airport_ref")
    private Long airportRef;

    @Column(name = "airport_ident")
    @CsvBindByName(column = "airport_ident")
    private String airportIdent;

    @Column(name = "length_ft")
    @CsvBindByName(column = "length_ft")
    private Long lengthFt;

    @Column(name = "width_ft")
    @CsvBindByName(column = "width_ft")
    private Long widthFt;

    @Column
    @CsvBindByName
    private String surface;

    @Column
    @CsvBindByName
    private int lighted;

    @Column
    @CsvBindByName
    private int closed;

    @Column(name = "le_ident")
    @CsvBindByName(column = "le_ident")
    private String leIndent;

    @Column(name = "le_latitude_deg")
    @CsvBindByName(column = "le_latitude_deg")
    private Double leLatitudeDeg;

    @Column(name = "le_longitude_deg")
    @CsvBindByName(column = "le_longitude_deg")
    private Double leLongitudeDeg;

    @Column(name = "le_elevation_ft")
    @CsvBindByName(column = "le_elevation_ft")
    private Integer leElevationFt;

    @Column(name = "le_heading_degT")
    @CsvBindByName(column = "le_heading_degT")
    private Double leHeadingDegT;

    @Column(name = "le_displaced_threshold_ft")
    @CsvBindByName(column = "le_displaced_threshold_ft")
    private Integer leDisplacedthresholdFt;

    @Column(name = "he_ident")
    @CsvBindByName(column = "he_ident")
    private String heIdent;


    @Column(name = "he_latitude_deg")
    @CsvBindByName(column = "he_latitude_deg")
    private Double heLatitudeDeg;

    @Column(name = "he_longitude_deg")
    @CsvBindByName(column = "he_longitude_deg")
    private Double heLongitudeDeg;

    @Column(name = "he_elevation_ft")
    @CsvBindByName(column = "he_elevation_ft")
    private Integer heElevationFt;

    @Column(name = "he_heading_degT")
    @CsvBindByName(column = "he_heading_degT")
    private Double heHeadingDegT;

    @Column(name = "he_displaced_threshold_ft")
    @CsvBindByName(column = "he_displaced_threshold_ft")
    private Integer heDisplacedthresholdFt;

}
