package com.accenture.assessment.airport.model;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAirportRef() {
        return airportRef;
    }

    public void setAirportRef(Long airportRef) {
        this.airportRef = airportRef;
    }

    public String getAirportIdent() {
        return airportIdent;
    }

    public void setAirportIdent(String airportIdent) {
        this.airportIdent = airportIdent;
    }

    public Long getLengthFt() {
        return lengthFt;
    }

    public void setLengthFt(Long lengthFt) {
        this.lengthFt = lengthFt;
    }

    public Long getWidthFt() {
        return widthFt;
    }

    public void setWidthFt(Long widthFt) {
        this.widthFt = widthFt;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public int getLighted() {
        return lighted;
    }

    public void setLighted(int lighted) {
        this.lighted = lighted;
    }

    public int getClosed() {
        return closed;
    }

    public void setClosed(int closed) {
        this.closed = closed;
    }

    public String getLeIndent() {
        return leIndent;
    }

    public void setLeIndent(String leIndent) {
        this.leIndent = leIndent;
    }

    public Double getLeLatitudeDeg() {
        return leLatitudeDeg;
    }

    public void setLeLatitudeDeg(Double leLatitudeDeg) {
        this.leLatitudeDeg = leLatitudeDeg;
    }

    public Double getLeLongitudeDeg() {
        return leLongitudeDeg;
    }

    public void setLeLongitudeDeg(Double leLongitudeDeg) {
        this.leLongitudeDeg = leLongitudeDeg;
    }

    public Integer getLeElevationFt() {
        return leElevationFt;
    }

    public void setLeElevationFt(Integer leElevationFt) {
        this.leElevationFt = leElevationFt;
    }

    public Double getLeHeadingDegT() {
        return leHeadingDegT;
    }

    public void setLeHeadingDegT(Double leHeadingDegT) {
        this.leHeadingDegT = leHeadingDegT;
    }

    public Integer getLeDisplacedthresholdFt() {
        return leDisplacedthresholdFt;
    }

    public void setLeDisplacedthresholdFt(Integer leDisplacedthresholdFt) {
        this.leDisplacedthresholdFt = leDisplacedthresholdFt;
    }

    public String getHeIdent() {
        return heIdent;
    }

    public void setHeIdent(String heIdent) {
        this.heIdent = heIdent;
    }

    public Double getHeLatitudeDeg() {
        return heLatitudeDeg;
    }

    public void setHeLatitudeDeg(Double heLatitudeDeg) {
        this.heLatitudeDeg = heLatitudeDeg;
    }

    public Double getHeLongitudeDeg() {
        return heLongitudeDeg;
    }

    public void setHeLongitudeDeg(Double heLongitudeDeg) {
        this.heLongitudeDeg = heLongitudeDeg;
    }

    public Integer getHeElevationFt() {
        return heElevationFt;
    }

    public void setHeElevationFt(Integer heElevationFt) {
        this.heElevationFt = heElevationFt;
    }

    public Double getHeHeadingDegT() {
        return heHeadingDegT;
    }

    public void setHeHeadingDegT(Double heHeadingDegT) {
        this.heHeadingDegT = heHeadingDegT;
    }

    public Integer getHeDisplacedthresholdFt() {
        return heDisplacedthresholdFt;
    }

    public void setHeDisplacedthresholdFt(Integer heDisplacedthresholdFt) {
        this.heDisplacedthresholdFt = heDisplacedthresholdFt;
    }
}
