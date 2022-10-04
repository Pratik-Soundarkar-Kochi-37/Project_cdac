package com.project.hosp.hospital.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.hosp.hospital.dto.AdminLoginDTO;
import com.project.hosp.hospital.dto.PatientDTO;
import com.project.hosp.hospital.dto.PatientDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class PatientRepository implements PatientInterface{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public String getallpatient(String pid) {
        try {
            List<Map<String, Object>> patient=jdbcTemplate.queryForList("select * from tblpatient where pid="+pid);
            String getPatient=objectMapper.writeValueAsString(patient);
            return getPatient;
        }
        catch (Exception ex){
            return "Error in fetching data";
        }


    }

    @Override
    public String addpatient(PatientDTO patientDTO) {
        try {
            String date=new Date().getDate()+"/"+new Date().getMonth()+"/"+new Date().getYear();
            String time=new Date().getHours()+":"+new Date().getMinutes()+":"+new Date().getSeconds();
            jdbcTemplate.execute("INSERT INTO `tblpatient`(`city`, `ddate`, `dob`, `email_id`, `first_name`, `flatno`, `gender`, `last_name`, `locality`, `password`, `pincode`, `ttime`) VALUES ('"+patientDTO.getCity()+"','"+date+"','"+patientDTO.getDob()+"','"+patientDTO.getEmailId()+"','"+patientDTO.getFirstName()+"','"+patientDTO.getFlatno()+"','"+patientDTO.getGender()+"','"+patientDTO.getLastName()+"','"+patientDTO.getLocality()+"','"+patientDTO.getPassword()+"','"+patientDTO.getPincode()+"','"+time+"')");
            //jdbcTemplate.execute("INSERT INTO `tbldoctor`(`first_name`, `last_name`) VALUES ('"+patientDTO.getFirstName()+"','"+patientDTO.getLastName()+"')");

            return "Patient Added Successfully";
        }
        catch (Exception ex){
            return "Error in Adding Patient";
        }
    }

    @Override
    public String deletePatientById(Long id) {
        try {
            jdbcTemplate.execute("delete from tblpatient where pid='"+id+"'");
            return "Patient Deleted Successfully";
        }
        catch (Exception ex){
            return "Error in Deleting Patient";
        }
    }

    @Override
    public String updatePatientById(PatientDTO patientDTO, Long id) {
        try {
            jdbcTemplate.execute("UPDATE `tblpatient` SET `city`='"+patientDTO.getCity()+"',`ddate`='"+patientDTO.getDdate()+"',`dob`='"+patientDTO.getDob()+"',`email_id`='"+patientDTO.getEmailId()+"',`first_name`='"+patientDTO.getFirstName()+"',`flatno`='"+patientDTO.getFlatno()+"',`gender`='"+patientDTO.getGender()+"',`last_name`='"+patientDTO.getLastName()+"',`locality`='"+patientDTO.getLocality()+"',`password`='"+patientDTO.getPassword()+"',`pincode`='"+patientDTO.getPincode()+"',`ttime`='"+patientDTO.getTtime()+"' where pid="+id);
            return "Patient Updated Successfully";
        }
        catch (Exception ex){
            return "Error in Updating Patient";
        }
    }

    @Override
    public String getPatientById(Long id) {
        try {
            List<Map<String, Object>> patient= jdbcTemplate.queryForList("select * from tblpatient where id="+id);
            String patientById=objectMapper.writeValueAsString(patient);
            return patientById;
        }
        catch (Exception ex){
            return "Error in Getting Patient By Id";
        }
    }

    @Override
    public String rlogin(PatientDTO patientDTO) {
        try {
            List<Map<String, Object>> patient= jdbcTemplate.queryForList("select * from tblpatient where email_id='"+patientDTO.getEmailId()+"' and password='"+patientDTO.getPassword()+"'");
            String result=objectMapper.writeValueAsString(patient);
            if(patient.stream().count()>=1){
                return result;
            }
            else{
                return "0";
            }

        }
        catch (Exception ex){
            return "Error in Getting Patient By Id";
        }
    }

    @Override
    public String addPatientDetails(PatientDetailsDTO patientDetailsDTO) {
        try {
            String date=new Date().getDate()+"/"+new Date().getMonth()+"/"+new Date().getYear();
            String time=new Date().getHours()+":"+new Date().getMinutes()+":"+new Date().getSeconds();

            jdbcTemplate.update("insert into tblpatientdetails(height,weight,pid,ddate,ttime,bloodoxygen,pulse,prescription,did)Values('"+patientDetailsDTO.getHeight()+"','"+patientDetailsDTO.getWeight()+"','"+patientDetailsDTO.getPid()+"','"+date+"','"+time+"','"+patientDetailsDTO.getBloodoxygen()+"','"+patientDetailsDTO.getPulse()+"','"+patientDetailsDTO.getPrescription()+"','"+patientDetailsDTO.getDid()+"')");
            return "Inserted";
        }
        catch (Exception ex){
            return "Error";
        }
    }

    @Override
    public String getAll() {
        try {
            List<Map<String, Object>> patient=jdbcTemplate.queryForList("select * from tblpatient");
            String getPatient=objectMapper.writeValueAsString(patient);
            return getPatient;
        }
        catch (Exception ex){
            return "Error in fetching data";
        }
    }

    @Override
    public String getPatientDetailsById(Long id) {
        try {
            List<Map<String, Object>> patient=jdbcTemplate.queryForList("select * from tblpatientdetails,tbldoctor where tbldoctor.did=tblpatientdetails.did and tblpatientdetails.pid="+id+" order by pdid desc");
            String getPatient=objectMapper.writeValueAsString(patient);
            return getPatient;
        }
        catch (Exception ex){
            return "Error in fetching data";
        }
    }

    @Override
    public String adminlogin(AdminLoginDTO adminLoginDTO) {
        try {
            List<Map<String, Object>> patient=jdbcTemplate.queryForList("select * from tbladmin where aemail='"+adminLoginDTO.getAemail()+"' and apass='"+adminLoginDTO.getApass()+"'");
            String result=objectMapper.writeValueAsString(patient);
            if(patient.stream().count()>=1){
                return result;
            }
            else{
                return "0";
            }

        }
        catch (Exception ex){
            return "Error in fetching data";
        }
    }

    @Override
    public String getAllDoctor() {
        try {
            List<Map<String, Object>> patient=jdbcTemplate.queryForList("select * from tbldoctor");
            String getPatient=objectMapper.writeValueAsString(patient);
            return getPatient;
        }
        catch (Exception ex){
            return "Error in fetching data";
        }
    }
}
