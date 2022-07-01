package com.globusdigital.patientsmanager.service.interfaces;

import com.globusdigital.patientsmanager.model.Consultation;

import java.util.List;

public interface ConsultationService {
    Consultation addConsultation(Consultation consultation);
    void deleteConsultation(Long id);
    Consultation updateConsultation(Consultation consultation);
    Consultation findConsultationById(Long id);
    List<Consultation> findAllConsultation();
}
