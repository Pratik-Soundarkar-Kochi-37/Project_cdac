package com.project.hosp.hospital.repository;

import com.project.hosp.hospital.dto.AdminLoginDTO;
import com.project.hosp.hospital.dto.PatientDTO;
import com.project.hosp.hospital.dto.PatientDetailsDTO;

public interface PatientInterface{
    String getallpatient(String pid);
    String addpatient(PatientDTO patientDTO);
    String deletePatientById(Long id);
    String updatePatientById(PatientDTO patientDTO, Long id);
    String getPatientById(Long id);
    String rlogin(PatientDTO rLoginDTO);
    String addPatientDetails(PatientDetailsDTO patientDetailsDTO);
    String getAll();
    String getPatientDetailsById(Long id);
    String adminlogin(AdminLoginDTO adminLoginDTO);

    String getAllDoctor();
}
