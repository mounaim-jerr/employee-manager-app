package com.globusdigital.patientsmanager.repo;

import com.globusdigital.patientsmanager.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultationRepo extends JpaRepository<Consultation , Long> {
    Optional<Consultation> findConsultationsById(Long id);
    List<Consultation> findByObservationContaining(String obs);

}
