package com.accenture.assessment.airport.dto;

import lombok.Data;

@Data
public class RunwayDto {

    private Long id;
    private Long airportRef;
    private String airportIdent;
    private Long lengthFt;
    private Long widthFt;
    private String surface;
    private int lighted;
    private int closed;
    private String leIndent;
    private Double leLatitudeDeg;
    private Double leLongitudeDeg;
    private Integer leElevationFt;
    private Double leHeadingDegT;
    private Integer leDisplacedthresholdFt;
    private String heIdent;
    private Double heLatitudeDeg;
    private Double heLongitudeDeg;
    private Integer heElevationFt;
    private Double heHeadingDegT;
    private Integer heDisplacedthresholdFt;

}
