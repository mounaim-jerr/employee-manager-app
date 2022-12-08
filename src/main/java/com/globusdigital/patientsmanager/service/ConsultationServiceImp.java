package com.globusdigital.patientsmanager.service;
import com.globusdigital.patientsmanager.exception.UserNotFoundException;
import com.globusdigital.patientsmanager.model.Consultation;
import com.globusdigital.patientsmanager.repo.ConsultationRepo;
import com.globusdigital.patientsmanager.service.interfaces.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationServiceImp implements ConsultationService {

    private final ConsultationRepo consultationRepo;
@Autowired
    public ConsultationServiceImp(ConsultationRepo consultationRepo) {
        this.consultationRepo = consultationRepo;
    }
    @Override
    public Consultation addConsultation(Consultation consultation){
        return consultationRepo.save(consultation);
    }
    @Override
    public void deleteConsultation(Long id){
    consultationRepo.deleteById(id);
    }
    @Override
    public Consultation updateConsultation(Consultation consultation){
    return consultationRepo.save(consultation);
    }
    @Override
    public Consultation findConsultationById(Long id){
   return consultationRepo.findConsultationsById(id).orElseThrow(() -> new UserNotFoundException("consultation by id " + id + "was not found"));
    }
    @Override
    public List<Consultation> findAllConsultation(){
    return consultationRepo.findAll();
    }
    @Override
    public    List<Consultation> findConsultationByObs(String obs){
    return consultationRepo.findByObservationContaining(obs);
    }
}
