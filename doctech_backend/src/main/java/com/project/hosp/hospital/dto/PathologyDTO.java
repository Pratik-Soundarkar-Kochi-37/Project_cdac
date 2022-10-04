package com.project.hosp.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PathologyDTO {
    private long pathalogyid;
    private String pathalogyname;
    private String emailId;
    private String password;
    private String mobileno;
    private String address;
}
