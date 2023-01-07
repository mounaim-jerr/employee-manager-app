package com.globusdigital.patientsmanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Consultation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column //(nullable = false)
    private LocalDate date ;
    @Column(nullable = false)
    private String observation;
    @Column
    private String medicament;

    @OneToOne
    @JoinColumn(nullable = false)
    private Doctor doctorConsul ;
    @OneToOne
    @JoinColumn(nullable = false)
    private Patient patientConsul;

    public Consultation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
