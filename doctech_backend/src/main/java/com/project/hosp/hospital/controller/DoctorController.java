package com.project.hosp.hospital.controller;

import com.project.hosp.hospital.dto.DoctorDTO;
import com.project.hosp.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @RequestMapping(method = RequestMethod.GET, value = "/doctor/getAllDoctors")
    public String getAllDoctors(){
        String data=doctorService.getAllDoctors();
        return ""+data;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/doctor/getAllDoctor/{id}")
    public String getAllDoctor(@PathVariable Long id){
        String data=doctorService.getAllDoctor(id);
        return ""+data;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/doctor/deletePatientById/{id}")
    public String getDeleteDoctor(@PathVariable Long id){
        String data=doctorService.getDeleteDoctor(id);
        return ""+data;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/doctor/addDoctor")
    public String addDoctor(@RequestBody DoctorDTO doctorDTO){
        String data=doctorService.addDoctor(doctorDTO);
        return ""+data;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/doctor/dlogin")
    public String login(@RequestBody DoctorDTO doctorDTO){
        String data=doctorService.login(doctorDTO);
        return ""+data;
    }



}
