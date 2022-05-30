package com.globusdigital.patientsmanager.repo;

import com.globusdigital.patientsmanager.model.Patient;
import com.globusdigital.patientsmanager.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecialityRepo extends JpaRepository<Speciality,Long> {
    Optional<Speciality> findSpecialitiesById(Long id);
    List<Speciality> findByNameContaining(String name);

}
