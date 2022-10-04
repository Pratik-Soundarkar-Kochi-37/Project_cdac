package com.project.hosp.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportDTO {
    private long reportid;
    private String data;
    private String value;
    private String pathalogyid;
    private String pid;
}
