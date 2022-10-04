package com.project.hosp.hospital.repository;

import com.project.hosp.hospital.dto.PathologyDTO;
import com.project.hosp.hospital.dto.PatientDTO;
import com.project.hosp.hospital.dto.PatientDetailsDTO;
import com.project.hosp.hospital.dto.ReportDTO;

public interface PathalogyInterface {
    String getAllPathalogy();
    String addPathalogy(PathologyDTO pathologyDTO);
    String pathlogin(PathologyDTO pathologyDTO);
    String addData(ReportDTO reportDTO);
    String getAllDetails(Long id);
}
