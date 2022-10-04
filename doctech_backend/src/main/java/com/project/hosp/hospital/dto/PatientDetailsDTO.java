package com.project.hosp.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDetailsDTO {
    private long pdid;
    private String pulse;
    private String bloodoxygen;
    private String weight;
    private String height;
    private String ddate;
    private String ttime;
    private long pid;
    private String prescription;
    private Integer did;
}

