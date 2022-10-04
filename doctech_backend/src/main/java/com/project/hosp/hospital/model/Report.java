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
@Table(name = "tblreport")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportid")
    private long reportid;
    @Column(name = "data")
    private String data;
    @Column(name = "value")
    private String value;
    @Column(name = "pathalogyid")
    private String pathalogyid;
    @Column(name = "ddate")
    private String ddate;
    @Column(name = "pid")
    private String pid;

}
