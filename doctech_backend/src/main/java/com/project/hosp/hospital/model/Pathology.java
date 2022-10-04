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
@Table(name = "tblpathalogy")
public class Pathology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pathalogy_id")
    private long pathalogyid;
    @Column(name = "pathalogyname")
    private String pathalogyname;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "password")
    private String password;
    @Column(name = "mobileno")
    private String mobileno;
    @Column(name = "address")
    private String address;


}
