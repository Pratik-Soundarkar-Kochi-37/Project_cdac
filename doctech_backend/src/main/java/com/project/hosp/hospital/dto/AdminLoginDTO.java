package com.project.hosp.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class AdminLoginDTO {

    private long adminid;
    private String aemail;
    private String apass;

}
