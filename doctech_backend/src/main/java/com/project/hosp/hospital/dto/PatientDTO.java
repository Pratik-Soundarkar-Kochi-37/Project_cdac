package com.project.hosp.hospital.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PatientDTO {
    private long pid;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private String gender;
    private int flatno;
    private String locality;
    private String pincode;
    private String city;
    private String dob;
    private String ddate;
    private String ttime;
}
