package com.project.hosp.hospital.service;

import com.project.hosp.hospital.dto.PathologyDTO;
import com.project.hosp.hospital.dto.PatientDTO;
import com.project.hosp.hospital.dto.PatientDetailsDTO;
import com.project.hosp.hospital.dto.ReportDTO;
import com.project.hosp.hospital.repository.PathalogyInterface;
import com.project.hosp.hospital.repository.PatientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PathalogyService {
    @Autowired
    PathalogyInterface pathalogyInterface;

    public String getAllPathalogy() {
        String pathalogy= pathalogyInterface.getAllPathalogy();
        return pathalogy;
    }

    public String addPathalogy(PathologyDTO pathologyDTO) {
        String pathalogy= pathalogyInterface.addPathalogy(pathologyDTO);
        return pathalogy;
    }

    public String pathlogin(PathologyDTO pathologyDTO) {
        String pathalogy= pathalogyInterface.pathlogin(pathologyDTO);
        return pathalogy;
    }

    public String addData(ReportDTO reportDTO) {
        String pathalogy= pathalogyInterface.addData(reportDTO);
        return pathalogy;
    }

    public String getAllDetails(Long id) {
        String getAllDetails= pathalogyInterface.getAllDetails(id);
        return getAllDetails;
    }
}
