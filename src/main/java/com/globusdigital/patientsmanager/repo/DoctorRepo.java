package com.globusdigital.patientsmanager.repo;

import com.globusdigital.patientsmanager.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findDoctorById(Long id);
   Optional<Doctor> findByDoctorName(String name);

}
