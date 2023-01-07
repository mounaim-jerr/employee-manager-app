package com.globusdigital.patientsmanager.model;

import com.globusdigital.patientsmanager.enums.Sex;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


//TODO i have to learn about Serializable
// TODO ask toufik about (collection , list(can duplicate and extend collection) , set(can't duplicate the same elements , extend collection ) ) which one i should use and why ?
@Entity
//@Table(name="T_Patient")
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    @Column(nullable = false, updatable = false)
    private String cin;
    //TODO ask if i should delete patientCode or not ?
    @Column(nullable = false, updatable = false)
    private String patientCode;

    //  add sex and nextRDV and address and dateOfBirth
    @Column
    private Sex sex;
    @Column
    private LocalDate nextRDV;
    @Column
    private String address;
    @Column
    private Date dateOfBirth;
    // @OneToOne( fetch = FetchType.LAZY )
    //private Doctor doctorTrait;


    public Patient(String name, String email, String phone, String cin) {
        //this.id = id; Long id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cin = cin;
        // this.patientCode = patientCode; String patientCode;
    }

    public Patient() {

    }

    public Patient(Long id, String name, String cin) {
        this.id = id;
        this.name = name;
        this.cin = cin;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getNextRDV() {
        return nextRDV;
    }

    public void setNextRDV(LocalDate nextRDV) {
        this.nextRDV = nextRDV;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//  public Doctor getDoctorTrait() {
    //    return doctorTrait;
    //}

    //  public void setDoctorTrait(Doctor doctorTrait) {
    //   this.doctorTrait = doctorTrait;
    //}

    @Override
    public String toString() {
        return "patient{ " +
                "id= " + id +
                ",name= '" + name + '\'' +
                ",email= '" + email + '\'' +
                ",phone= '" + phone + '\'' +
                ",cin= '" + cin + '\'' +
                '}';
    }
}
