package com.project.hosp.hospital.controller;

import com.project.hosp.hospital.dto.AdminLoginDTO;
import com.project.hosp.hospital.dto.PatientDTO;
import com.project.hosp.hospital.dto.PatientDetailsDTO;
import com.project.hosp.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @RequestMapping(method = RequestMethod.GET, value = "/patient/getAllPatient/{pid}")
    public String getAllPatient(@PathVariable String pid){
        String data=patientService.getallpatient(pid);
        return ""+data;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/patient/getAll")
    public String getAll(){
        String data=patientService.getall();
        return ""+data;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/patient/getPatientById/{id}")
    public String getPatientById(@PathVariable Long id){
        String getPatientById=patientService.getPatientById(id);
        return ""+getPatientById;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/patient/addPatient")
    public String addPatient(@RequestBody PatientDTO patientDTO){
        String addPatient=patientService.addpatient(patientDTO);
        return ""+addPatient;
    }
    @RequestMapping(method = RequestMethod.POST, value = "/patient/addPatientDetails")
    public String addPatientDetails(@RequestBody PatientDetailsDTO patientDetailsDTO){
        String patientDetails=patientService.addPatientDetails(patientDetailsDTO);
        return ""+patientDetails;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/patient/updatePatientById/{Id}")
    public String updatePatientById(@RequestBody PatientDTO patientDTO,@PathVariable Long Id){
        String updatePatientById=patientService.updatePatientById(patientDTO,Id);
        return ""+updatePatientById;
    }
    @RequestMapping(method = RequestMethod.POST, value = "/patient/login")
    public String rlogin(@RequestBody PatientDTO patientDTO){
        String rlogin=patientService.rlogin(patientDTO);
        return ""+rlogin;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/patient/deletePatientById/{Id}")
    public String deletePatientById(@PathVariable Long Id){
        String deletePatientById=patientService.deletePatientById(Id);
        return ""+deletePatientById;
    }
        @RequestMapping(method = RequestMethod.GET, value = "/patient/patientDetails/{Id}")
    public String patientDetailsById(@PathVariable Long Id){
        String patientDetailsById=patientService.getPatientDetailsById(Id);
        return ""+patientDetailsById;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin/getAllDoctor")
    public String getAllDoctor(){
        String getAllDoctor=patientService.getAllDoctor();
        return ""+getAllDoctor;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/login")
    public String adminlogin(@RequestBody AdminLoginDTO adminLoginDTO){
        String patientDetailsById=patientService.adminlogin(adminLoginDTO);
        return ""+patientDetailsById;
    }



}
