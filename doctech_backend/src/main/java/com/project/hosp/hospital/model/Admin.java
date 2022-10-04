package com.project.hosp.hospital.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbladmin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminid")
    private long pid;
    @Column(name = "aemail")
    private String aemail;
    @Column(name = "apass")
    private String apass;
    
}
