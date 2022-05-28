package com.globusdigital.patientsmanager.repo;

import com.globusdigital.patientsmanager.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient, Long> {
  //  void deletePatientById(Long id);
    Optional<Patient>  findPatientById(Long id);
    List<Patient> findByNameContaining(String name);
}
