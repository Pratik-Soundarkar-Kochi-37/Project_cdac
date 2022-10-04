package com.project.hosp.hospital.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class MedicalRecordsDTO {
    private long mrid;
    private String disease;
    private String medicine;
    private String timing;
    private String ddate;
    private String ttime;
    private String pid;
}
