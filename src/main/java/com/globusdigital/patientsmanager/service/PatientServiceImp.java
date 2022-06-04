package com.globusdigital.patientsmanager.service;

import com.globusdigital.patientsmanager.exception.UserNotFoundException;
import com.globusdigital.patientsmanager.model.Patient;
import com.globusdigital.patientsmanager.repo.PatientRepo;
import com.globusdigital.patientsmanager.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientServiceImp implements PatientService {

    private final PatientRepo patientRepo;
    @Autowired
    public PatientServiceImp(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    @Override
    public Patient addPatient(Patient patient) {
        patient.setPatientCode(UUID.randomUUID().toString());
        return patientRepo.save(patient);
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepo.findAll();
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientRepo.findPatientById(id).orElseThrow(() -> new UserNotFoundException("user by id " + id + "was not found"));
    }

    @Override
    public List<Patient> findPatientByName(String name) {
        return patientRepo.findByNameContaining(name);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepo.deleteById(id);
    }


}
