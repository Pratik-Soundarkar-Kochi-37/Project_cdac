package com.project.hosp.hospital.controller;

import com.project.hosp.hospital.dto.PathologyDTO;
import com.project.hosp.hospital.dto.ReportDTO;
import com.project.hosp.hospital.service.PathalogyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class PathalogyController {
    @Autowired
    PathalogyService pathalogyService;

    @RequestMapping(method = RequestMethod.GET, value = "/pathalogy/getAllPathology")
    public String getAllPathalogy(){
        String data=pathalogyService.getAllPathalogy();
        return ""+data;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pathalogy/addPathalogy")
    public String addPathalogy(@RequestBody PathologyDTO pathologyDTO){
        String data=pathalogyService.addPathalogy(pathologyDTO);
        return ""+data;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pathalogy/pathlogin")
    public String login(@RequestBody PathologyDTO pathologyDTO){
        String data=pathalogyService.pathlogin(pathologyDTO);
        return ""+data;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pathalogy/adddata")
    public String login(@RequestBody ReportDTO reportDTO){
        String data=pathalogyService.addData(reportDTO);
        return ""+data;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/patient/getalldetails/{id}")
    public String getAllDetails(@PathVariable Long id){
        String data=pathalogyService.getAllDetails(id);
        return ""+data;
    }



}
