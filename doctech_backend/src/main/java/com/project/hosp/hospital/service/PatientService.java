package com.project.hosp.hospital.service;

import com.project.hosp.hospital.dto.AdminLoginDTO;
import com.project.hosp.hospital.dto.PatientDTO;
import com.project.hosp.hospital.dto.PatientDetailsDTO;
import com.project.hosp.hospital.repository.PatientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientInterface patientInterface;


    public String getallpatient(String pid) {
       String patient= patientInterface.getallpatient(pid);
       return patient;
    }

    public String addpatient(PatientDTO patientDTO) {
        String patient= patientInterface.addpatient(patientDTO);
        return patient;
    }

    public String deletePatientById(Long Id) {
        String deletePatientById= patientInterface.deletePatientById(Id);
        return deletePatientById;
    }

    public String updatePatientById(PatientDTO patientDTO, Long id) {
        String updatePatientById= patientInterface.updatePatientById(patientDTO,id);
        return updatePatientById;
    }

    public String getPatientById(Long id) {
        String getPatientById= patientInterface.getPatientById(id);
        return getPatientById;
    }

    public String rlogin(PatientDTO patientDTO) {
        String rlogin= patientInterface.rlogin(patientDTO);
        return rlogin;
    }

    public String addPatientDetails(PatientDetailsDTO patientDetailsDTO) {
        String patientDetails=patientInterface.addPatientDetails(patientDetailsDTO);
        return patientDetails;
    }

    public String getall() {
        String patientDetails=patientInterface.getAll();
        return patientDetails;
    }

    public String getPatientDetailsById(Long id) {
        String getPatientDetailsById=patientInterface.getPatientDetailsById(id);
        return getPatientDetailsById;
    }


    public String adminlogin(AdminLoginDTO adminLoginDTO) {
        String adminLogin=patientInterface.adminlogin(adminLoginDTO);
        return adminLogin;
    }

    public String getAllDoctor() {
        String getAllDoctor=patientInterface.getAllDoctor();
        return getAllDoctor;
    }
}
