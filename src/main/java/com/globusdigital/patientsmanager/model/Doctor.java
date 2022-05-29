package com.globusdigital.patientsmanager.model;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column
    private String doctorName;
    @Column(nullable = false,updatable = false)
    private String doctorCin;
    @Column(nullable = false,updatable = false)
    private String doctorCode;
    @Column
    private String doctorEmail;
    @Column
    private String doctorGender;
    @Column(nullable = false)
    private Speciality doctorSpeciality;
    @Column
    private Date doctorBornDate;
    //private List<Patient> patient;

    public Doctor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorCin() {
        return doctorCin;
    }

    public void setDoctorCin(String doctorCin) {
        this.doctorCin = doctorCin;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorGender() {
        return doctorGender;
    }

    public void setDoctorGender(String doctorGender) {
        this.doctorGender = doctorGender;
    }

    public Speciality getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(Speciality doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }

    public Date getDoctorBornDate() {
        return doctorBornDate;
    }

    public void setDoctorBornDate(Date doctorBornDate) {
        this.doctorBornDate = doctorBornDate;
    }
}
