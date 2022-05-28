package com.globusdigital.patientsmanager.service;

import com.globusdigital.patientsmanager.exception.UserNotFoundException;
import com.globusdigital.patientsmanager.model.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    public Patient addPatient(Patient patient);
    public List<Patient> findAllPatients();
    public Patient updatePatient(Patient patient);
    public Patient findPatientById(Long id);
    public List<Patient> findPatientByName(String name);
    public void deletePatient(Long id);


}
