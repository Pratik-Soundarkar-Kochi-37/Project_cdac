package com.project.hosp.hospital.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentDTO {
    private long dpaid;
    private int did;
    private int pid;
    private int atime;
    private int adate;
}
