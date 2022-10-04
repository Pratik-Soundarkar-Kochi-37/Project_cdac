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
@Table(name = "tblpatientdetails")
public class PatientDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pdid")
    private long pdid;
    @Column(name = "pulse")
    private String pulse;
    @Column(name = "bloodoxygen")
    private String bloodoxygen;
    @Column(name = "height")
    private String height;
    @Column(name = "weight")
    private String weight;
    @Column(name = "ddate")
    private String ddate;
    @Column(name = "ttime")
    private String ttime;
    @Column(name = "prescription")
    private String prescription;
    @Column(name = "did")
    private Integer did;
    @Column(name = "pid")
    private long pid;
}
