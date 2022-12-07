package com.globusdigital.patientsmanager.controllers;

import com.globusdigital.patientsmanager.model.Patient;
import com.globusdigital.patientsmanager.model.Speciality;
import com.globusdigital.patientsmanager.service.interfaces.SpecialityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {
    private final SpecialityService specialityServiceImp;

    public SpecialityController(SpecialityService specialityServiceImp) {
        this.specialityServiceImp = specialityServiceImp;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Speciality>> getAllSpeciality(){
        List<Speciality> specialityList = specialityServiceImp.findAllSpeciality();
        return new ResponseEntity<>(specialityList, HttpStatus.OK);
    }
}
