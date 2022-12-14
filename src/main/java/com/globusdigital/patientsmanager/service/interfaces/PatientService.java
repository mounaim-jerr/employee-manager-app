package com.globusdigital.patientsmanager.service.interfaces;


import com.globusdigital.patientsmanager.model.Patient;

import java.util.List;
public interface PatientService {
    Patient addPatient(Patient patient);

    List<Patient> findAllPatients();

    Patient updatePatient(Patient patient);

    Patient findPatientById(Long id);

    List<Patient> findPatientByName(String name);

    void deletePatient(Long id);


}
