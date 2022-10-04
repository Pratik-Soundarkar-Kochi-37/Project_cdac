package com.project.hosp.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbldoctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did")
    private long did;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "demail_id")
    private String demailId;
    @Column(name = "dpassword")
    private String dpassword;
    @Column(name = "degree")
    private String degree;
    @Column(name = "collegename")
    private String collegename;
    @Column(name = "passout")
    private String passout;
    @Column(name = "fees")
    private String fees;
    @Column(name = "flatno")
    private int flatno;
    @Column(name = "locality")
    private String locality;
    @Column(name = "pincode")
    private String pincode;
    @Column(name = "city")
    private String city;
    @Column(name = "dob")
    private String dob;
    @Column(name = "status")
    private String status;
    @Column(name = "intime")
    private String intime;
    @Column(name = "outtime")
    private String outtime;
    @Column(name = "ddate")
    private String ddate;
    @Column(name = "ttime")
    private String ttime;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "hospital_name")
    private String hospitalName;
}
