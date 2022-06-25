package com.globusdigital.patientsmanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Consultation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(nullable = false)
    private Date date ;
    @Column(nullable = false)
    private String observation;
    @Column
    private String medicament;
    @Column
    private Date prochainRdv;
    @OneToOne
    private Doctor doctorConsul ;
    @OneToOne
    private Patient patientConsul;

    public Consultation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public Date getProchainRdv() {
        return prochainRdv;
    }

    public void setProchainRdv(Date prochainRdv) {
        this.prochainRdv = prochainRdv;
    }

    public Doctor getDoctorConsul() {
        return doctorConsul;
    }

    public void setDoctorConsul(Doctor doctorConsul) {
        this.doctorConsul = doctorConsul;
    }

    public Patient getPatientConsul() {
        return patientConsul;
    }

    public void setPatientConsul(Patient patientConsul) {
        this.patientConsul = patientConsul;
    }
}
