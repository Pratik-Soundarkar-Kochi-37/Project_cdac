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
@Table(name = "tblmedicalrecords")
public class MedicalRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mrid")
    private long mrid;
    @Column(name = "disease")
    private String disease;
    @Column(name = "medicine")
    private String medicine;
    @Column(name = "timing")
    private String timing;
    @Column(name = "ddate")
    private String ddate;
    @Column(name = "ttime")
    private String ttime;
    @Column(name = "pid")
    private String pid;
}
