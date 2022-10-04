package com.project.hosp.hospital.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.hosp.hospital.dto.PathologyDTO;
import com.project.hosp.hospital.dto.PatientDTO;
import com.project.hosp.hospital.dto.PatientDetailsDTO;
import com.project.hosp.hospital.dto.ReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class PathologyRepository implements PathalogyInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String getAllPathalogy() {
        try {
            List<Map<String, Object>> patient = jdbcTemplate.queryForList("select * from tblpathalogy");
            String getPatient = objectMapper.writeValueAsString(patient);
            return getPatient;
        } catch (Exception ex) {
            return "Error in fetching data";
        }
    }

    @Override
    public String addPathalogy(PathologyDTO pathologyDTO) {
        try {

            String date = new Date().getDate() + "/" + new Date().getMonth() + "/" + new Date().getYear();
            String time = new Date().getHours() + ":" + new Date().getMinutes() + ":" + new Date().getSeconds();
            jdbcTemplate.execute("INSERT INTO `tblpathalogy`(`address`, `email_id`, `mobileno`, `password`, `pathalogyname`) VALUES ('" + pathologyDTO.getAddress() + "','" + pathologyDTO.getEmailId() + "','" + pathologyDTO.getMobileno() + "','" + pathologyDTO.getPassword() + "','" + pathologyDTO.getPathalogyname() + "')");
            return "Pathalogy Added Successfully";
        } catch (Exception ex) {
            return "Error in Adding Patient";
        }
    }

    @Override
    public String pathlogin(PathologyDTO pathologyDTO) {
        try {
            List<Map<String, Object>> pathology = jdbcTemplate.queryForList
                    ("select * from tblpathalogy where email_id='"
                            + pathologyDTO.getEmailId() + "' and password='"
                            + pathologyDTO.getPassword() + "'");
            String result = objectMapper.writeValueAsString(pathology);
            if (pathology.stream().count() >= 1) {
                return result;
            } else {
                return "0";
            }

        } catch (Exception ex) {
            return "Error in Getting Patient By Id";
        }
    }

    @Override
    public String addData(ReportDTO reportDTO) {
        try {
            String ddate=new Date().toGMTString();
            jdbcTemplate.update("INSERT INTO `tblreport`(" +
                    "`data`, `pathalogyid`, `value`, `pid`, `ddate`) " +
                    "VALUES ('" + reportDTO.getData() + "','"
                    + reportDTO.getPathalogyid() + "','"
                    + reportDTO.getValue() + "','"+reportDTO.getPid()+"'," +
                    "'"+ddate+"')");
            return "1";
        } catch (Exception ex) {
            return "Error in Getting Patient By Id";
        }
    }

    @Override
    public String getAllDetails(Long id) {
        try {
            List<Map<String, Object>> patient = jdbcTemplate.queryForList(
                    "select * from tblreport where pid="+id+" " +
                            "order by reportid desc");
            String getPatient = objectMapper.writeValueAsString(patient);
            return getPatient;
        } catch (Exception ex) {
            return "Error in fetching data";
        }
    }

}
