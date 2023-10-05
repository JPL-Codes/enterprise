package com.myplantdiary.enterprise.dto;

import lombok.Data;

public @Data class Specimen {

    private int PlantId;
    private String SpeciId;
    private String Latitude;
    private String Longitude;
    private String Description;
}
