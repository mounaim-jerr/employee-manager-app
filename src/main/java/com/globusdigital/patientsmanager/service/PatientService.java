package com.globusdigital.patientsmanager.service;


import com.globusdigital.patientsmanager.model.Patient;

import java.util.List;

//TODO ask taoufik about this
public interface PatientService {
    Patient addPatient(Patient patient);
     List<Patient> findAllPatients();
     Patient updatePatient(Patient patient);
     Patient findPatientById(Long id);
     List<Patient> findPatientByName(String name);
     void deletePatient(Long id);


}
