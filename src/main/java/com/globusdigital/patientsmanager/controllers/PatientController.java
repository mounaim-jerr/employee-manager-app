package com.globusdigital.patientsmanager.controllers;

import com.globusdigital.patientsmanager.model.Patient;
import com.globusdigital.patientsmanager.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    //@Autowired

    private final PatientService patientServiceImp;
    @Autowired
    public PatientController(PatientService patientServiceImp) {
        this.patientServiceImp = patientServiceImp;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients(){
        List<Patient> patients = patientServiceImp.findAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long id){
        Patient patient = patientServiceImp.findPatientById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        Patient newPatient = patientServiceImp.addPatient(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);

    }
    @PutMapping("/update")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
        Patient updatePatient = patientServiceImp.updatePatient(patient);
        return new ResponseEntity<>(updatePatient, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable("id") Long id ){
        patientServiceImp.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

