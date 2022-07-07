package com.globusdigital.patientsmanager.controllers;

import com.globusdigital.patientsmanager.model.Doctor;
import com.globusdigital.patientsmanager.model.Patient;
import com.globusdigital.patientsmanager.service.interfaces.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorControllers {
    private final DoctorService doctorServiceImp;

    public DoctorControllers(DoctorService doctorServiceImp) {
        this.doctorServiceImp = doctorServiceImp;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        List<Doctor> doctors = doctorServiceImp.findAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable ("id") Long id){
        Doctor doctor = doctorServiceImp.findDoctorById(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }
    @GetMapping("/find/{name}")
    public ResponseEntity<List<Doctor>> getDoctorsByName(@PathVariable ("name") String name){
        List<Doctor> doctors = doctorServiceImp.findDoctorByName(name);
        return new ResponseEntity<>(doctors, HttpStatus.OK);

    }
    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
        Doctor newDoctor = doctorServiceImp.addDoctor(doctor);
        return new ResponseEntity<>(newDoctor , HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor){
        Doctor updateDoctor = doctorServiceImp.updateDoctor(doctor);
        return new ResponseEntity<>(updateDoctor, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable ("id") Long id){
        doctorServiceImp.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
