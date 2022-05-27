package com.globusdigital.patientsmanager.repo;

import com.globusdigital.patientsmanager.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    void deletePatientsById(Long id);
    Optional<Patient> findPatientsById(Long id);
}
