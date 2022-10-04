package com.project.hosp.hospital.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.hosp.hospital.dto.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class DoctorRepository implements DoctorInterface{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    ObjectMapper objectMapper=new ObjectMapper();

    @Override
    public String getallDoctors() {
        try {
            List<Map<String, Object>> patient=jdbcTemplate.queryForList
                    ("select * from tbldoctor");
            String getDoctors=objectMapper.writeValueAsString(patient);
            return getDoctors;
        }
        catch (Exception ex){
            return "Error in fetching data";
        }
    }

    @Override
    public String addDoctor(DoctorDTO doctorDTO) {
        try {
            String ddate=new Date().getDate()+"/"+new Date().getMonth()+"/"+new Date().getYear();
            String time=new Date().getHours()+":"+new Date().getMinutes()+":"+new Date().getSeconds();

            jdbcTemplate.execute("INSERT INTO `tbldoctor`(`first_name`, " +
                    "`last_name`,`demail_id`,`city`,`collegename`,`degree`," +
                    "`department_name`,`ddate`,`ttime`,`dob`,`dpassword`) " +
                    "VALUES ('"+doctorDTO.getFirstName()+"','"+doctorDTO.getLastName()+"'," +
                    "'"+doctorDTO.getDemailId()+"','"+doctorDTO.getCity()+"','" +
                    ""+doctorDTO.getCollegename()+"','"+doctorDTO.getDegree()+"','" +
                    ""+doctorDTO.getDepartmentName()+"','"+ddate+"','"+time+"','" +
                    ""+doctorDTO.getDob()+"','"+doctorDTO.getDpassword()+"')");

            return "Inserted";
        }
        catch (Exception ex){
            return "Error in posting data";
        }
    }

    @Override
    public String login(DoctorDTO doctorDTO) {
        try {
            List<Map<String, Object>> patient=jdbcTemplate.queryForList
                    ("select * from tbldoctor where demail_id='"+doctorDTO.getDemailId()+"" +
                            "' and dpassword='"+doctorDTO.getDpassword()+"'");
            System.out.println("select * from tbldoctor where demail_id='" +
                    ""+doctorDTO.getDemailId()+"' and dpassword='" +
                    ""+doctorDTO.getDpassword()+"'");

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
    public String getallDoctor(Long id) {
        try {
            List<Map<String, Object>> patient=jdbcTemplate.queryForList
                    ("select * from tbldoctor where did="+id);
            String getDoctors=objectMapper.writeValueAsString(patient);
            return getDoctors;
        }
        catch (Exception ex){
            return "Error in fetching data";
        }
    }

    @Override
    public String getDeleteDoctor(Long id) {
        jdbcTemplate.execute("delete from tbldoctor where did="+id);
        return null;
    }
}
