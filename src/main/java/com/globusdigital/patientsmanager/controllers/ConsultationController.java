package com.globusdigital.patientsmanager.controllers;

import com.globusdigital.patientsmanager.model.Consultation;
import com.globusdigital.patientsmanager.service.interfaces.ConsultationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {
    private final ConsultationService consultationServiceImp;

    public ConsultationController(ConsultationService consultationServiceImp) {
        this.consultationServiceImp = consultationServiceImp;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Consultation>> getAllConsultations(){
        List<Consultation> consultations = consultationServiceImp.findAllConsultation();
        return new ResponseEntity<>(consultations, HttpStatus.OK);
    }
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Consultation> getConsultationById(@PathVariable("id") Long id){
        Consultation consultation = consultationServiceImp.findConsultationById(id);
        return new ResponseEntity<>(consultation,HttpStatus.OK);
    }
    @GetMapping("/find/observation/{obs}")
    public ResponseEntity<List<Consultation>> findConsultationsByName(@PathVariable("obs") String obs){
        List<Consultation> consultations = consultationServiceImp.findConsultationByObs(obs);
        return new ResponseEntity<>(consultations,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Consultation> addConsultation(@RequestBody Consultation consultation){
       Consultation newConsultation = consultationServiceImp.addConsultation(consultation) ;
        return new ResponseEntity<>(newConsultation, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Consultation> updateConsultation(@RequestBody Consultation consultation){
        Consultation updateConsultation = consultationServiceImp.updateConsultation(consultation) ;
        return new ResponseEntity<>(updateConsultation, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteConsultation(@PathVariable ("id") Long id){
        consultationServiceImp.deleteConsultation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
