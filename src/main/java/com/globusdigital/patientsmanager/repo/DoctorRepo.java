package com.globusdigital.patientsmanager.repo;

import com.globusdigital.patientsmanager.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findDoctorById(Long id);
   Optional<Doctor> findByDoctorName(String name);

}
