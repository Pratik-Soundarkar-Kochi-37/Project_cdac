package com.project.hosp.hospital.repository;
import com.project.hosp.hospital.dto.DoctorDTO;

public interface DoctorInterface {
    String getallDoctors();
    String addDoctor(DoctorDTO doctorDTO);
    String login(DoctorDTO doctorDTO);
    String getallDoctor(Long id);

    String getDeleteDoctor(Long id);
}
