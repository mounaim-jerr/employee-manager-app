package com.globusdigital.patientsmanager.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name ;
    private String email ;

    private String phone;
    @Column(nullable = false,updatable = false)
    private String cin;
    @Column(nullable = false,updatable = false)
    private String patientCode;

    public Patient(Long id, String name, String email, String phone, String cin, String patientCode) {
        this.id = id;
        this.name = name;
        this.email = email;

        this.phone = phone;
        this.cin = cin;
        this.patientCode = patientCode;
    }

    public Patient() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String imageUrl) {
        this.cin = imageUrl;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }
    @Override
    public  String toString() {
        return "patient{ " +
                "id= " + id +
                ",name= '" + name + '\'' +
                ",email= '" + email + '\'' +
                ",phone= '" + phone + '\'' +
                ",cin= '" + cin + '\'' +
                  '}';
    }
}
