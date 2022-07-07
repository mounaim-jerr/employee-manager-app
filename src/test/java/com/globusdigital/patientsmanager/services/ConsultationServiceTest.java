package com.globusdigital.patientsmanager.services;

import com.globusdigital.patientsmanager.model.Consultation;
import com.globusdigital.patientsmanager.repo.ConsultationRepo;
import com.globusdigital.patientsmanager.service.ConsultationServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ConsultationServiceTest {
    @Autowired
    ConsultationServiceImp consultationServiceImp;
    @Autowired
    ConsultationRepo consultationRepo ;

    @BeforeEach
    public void initContext(){
        consultationRepo.deleteAll();
    }
    public List<Consultation> addThreeConsultation(String obs1 , String obs2 , String obs3){
        Consultation consultation = new Consultation();
        Consultation consultation1 = new Consultation();
        Consultation consultation2 = new Consultation();
        consultation.setObservation("obs1");
        consultation1.setObservation("obs2");
        consultation2.setObservation("obs3");
        consultationServiceImp.addConsultation(consultation);
        consultationServiceImp.addConsultation(consultation1);
        consultationServiceImp.addConsultation(consultation2);
        return consultationRepo.findAll();
    }
    @Test
    public void addConsultationTest(){
        Consultation consultation = new Consultation();
        Consultation consultation1 = new Consultation();
        Consultation consultation2 = new Consultation();
        consultation.setObservation("obs1");
        consultation1.setObservation("obs2");
        consultation2.setObservation("obs3");
        consultationServiceImp.addConsultation(consultation);
        consultationServiceImp.addConsultation(consultation1);
        consultationServiceImp.addConsultation(consultation2);
        List<Consultation> listConsultation = consultationRepo.findAll();
        Assertions.assertThat(listConsultation.size()).isEqualTo(3);
    }
    @Test
    public void deleteConsultationTest(){
        List<Consultation> listConsultation = addThreeConsultation("obs1","obs2","obs3");
        consultationServiceImp.deleteConsultation(listConsultation.get(1).getId());
        listConsultation = consultationRepo.findAll();
        Assertions.assertThat(listConsultation.size()).isEqualTo(2);
    }
    @Test
    public void findConsultationByIdTest(){

        List<Consultation> listConsultation = addThreeConsultation("obs1","obs2","obs3");
        Consultation consultation= consultationServiceImp.findConsultationById(listConsultation.get(1).getId());
    Assertions.assertThat(consultation.getId()).isEqualTo(listConsultation.get(1).getId());
        Assertions.assertThat(consultation.getMedicament()).isEqualTo(listConsultation.get(1).getMedicament());
    }
    @Test
    public void updateConsultationTest(){
        List<Consultation> listConsultation = addThreeConsultation("obs1","obs2","obs3");
        Consultation consultation= consultationServiceImp.findConsultationById(listConsultation.get(1).getId());
        consultation.setObservation("obsUpdate1");
        consultationServiceImp.addConsultation(consultation);
        listConsultation = consultationServiceImp.findAllConsultation();
        Assertions.assertThat(listConsultation.get(1).getObservation()).isEqualTo("obsUpdate1");
    }
}
