package com.globusdigital.patientsmanager.service;

import com.globusdigital.patientsmanager.exception.UserNotFoundException;
import com.globusdigital.patientsmanager.model.Patient;
import com.globusdigital.patientsmanager.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepo patientRepo;
    @Autowired
    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }
    public Patient addPatient(Patient patient){
    patient.setPatientCode(UUID.randomUUID().toString());
    return patientRepo.save(patient);
    }
    public List<Patient> findAllPatients(){
    return patientRepo.findAll();
    }
    public Patient updatePatient(Patient patient){
    return patientRepo.save(patient);
    }
    public Patient findPatientById(Long id){
    return patientRepo.findPatientById(id).orElseThrow(() -> new UserNotFoundException("user by id " + id + "was not found"));
    }
    public void deletePatient(Long id){
    patientRepo.deleteById(id);
    }
    public  void deleteAllPatients(){
        patientRepo.deleteAll();
    }

}
