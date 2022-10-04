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
@Table(name = "doc_pat_app")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpaid")
    private long dpaid;
    @Column(name = "did")
    private int did;
    @Column(name = "pid")
    private int pid;
    @Column(name = "atime")
    private int atime;
    @Column(name = "adate")
    private int adate;
}
