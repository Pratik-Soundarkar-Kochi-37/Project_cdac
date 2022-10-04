package com.project.hosp.hospital.service;

import com.project.hosp.hospital.dto.DoctorDTO;
import com.project.hosp.hospital.repository.DoctorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    DoctorInterface doctorInterface;


    public String getAllDoctors() {
        String res= doctorInterface.getallDoctors();
        return res;
    }

    public String addDoctor(DoctorDTO doctorDTO) {
        String res= doctorInterface.addDoctor(doctorDTO);
        return res;
    }

    public String login(DoctorDTO doctorDTO) {
        String res= doctorInterface.login(doctorDTO);
        return res;
    }

    public String getAllDoctor(Long id) {
        String res= doctorInterface.getallDoctor(id);
        return res;
    }

    public String getDeleteDoctor(Long id) {
        String res= doctorInterface.getDeleteDoctor(id);
        return res;
    }
}
