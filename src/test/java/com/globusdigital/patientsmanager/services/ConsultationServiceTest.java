package com.globusdigital.patientsmanager.services;

import com.globusdigital.patientsmanager.model.*;
import com.globusdigital.patientsmanager.repo.*;
import com.globusdigital.patientsmanager.service.*;
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
    DepartmentServiceImp departmentServiceImp;
    @Autowired
    SpecialityServiceImp specialityServiceImp;
    @Autowired
    DoctorServiceImp doctorServiceImp;
    @Autowired
    PatientServiceImp patientServiceImp;
    @Autowired
    DepartmentRepo departmentRepo;
    @Autowired
    SpecialityRepo specialityRepo;
    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    PatientRepo patientRepo;
    @Autowired
    ConsultationRepo consultationRepo;
    @BeforeEach
    public void initContext() {
        consultationRepo.deleteAll();
        patientRepo.deleteAll();
        doctorRepo.deleteAll();
        specialityRepo.deleteAll();
        departmentRepo.deleteAll();
    }

    public List<Consultation> addThreeConsultation(){
        Department department = new Department();
        department.setName("department");
        departmentServiceImp.addDepartment(department);
        Speciality speciality = new Speciality();
        speciality.setName("speciality");
        speciality.setDepartment(department);
        specialityServiceImp.addSpeciality(speciality);
        Doctor doctor = new Doctor();
        doctor.setCin("doctorcin");
        doctor.setName("doctor");
        doctor.setSpeciality(speciality);
        doctorServiceImp.addDoctor(doctor);
        Patient patient = new Patient();
        patient.setCin("patientcin");
        patient.setName("patient");
        patientServiceImp.addPatient(patient);
        Consultation consultation = new Consultation();
        Consultation consultation1 = new Consultation();
        Consultation consultation2 = new Consultation();
        consultation.setObservation("obs1");
        consultation1.setObservation("obs2");
        consultation2.setObservation("obs3");
        consultation.setPatientConsul(patient);
        consultation1.setPatientConsul(patient);
        consultation2.setPatientConsul(patient);
        consultation.setDoctorConsul(doctor);
        consultation1.setDoctorConsul(doctor);
        consultation2.setDoctorConsul(doctor);
        consultationServiceImp.addConsultation(consultation);
        consultationServiceImp.addConsultation(consultation1);
        consultationServiceImp.addConsultation(consultation2);
        return consultationRepo.findAll();
    }
    @Test
    public void addConsultationTest(){
        Department department = new Department();
        department.setName("department");
        departmentServiceImp.addDepartment(department);
        Speciality speciality = new Speciality();
        speciality.setName("speciality");
        speciality.setDepartment(department);
        specialityServiceImp.addSpeciality(speciality);
        Doctor doctor = new Doctor();
        doctor.setCin("doctorcin");
        doctor.setName("doctor");
        doctor.setSpeciality(speciality);
        doctorServiceImp.addDoctor(doctor);
        Patient patient = new Patient();
        patient.setCin("patientcin");
        patient.setName("patient");
        patientServiceImp.addPatient(patient);
        Consultation consultation = new Consultation();
        Consultation consultation1 = new Consultation();
        Consultation consultation2 = new Consultation();
        consultation.setObservation("obs1");
        consultation1.setObservation("obs2");
        consultation2.setObservation("obs3");
        consultation.setPatientConsul(patient);
        consultation1.setPatientConsul(patient);
        consultation2.setPatientConsul(patient);
        consultation.setDoctorConsul(doctor);
        consultation1.setDoctorConsul(doctor);
        consultation2.setDoctorConsul(doctor);
        consultationServiceImp.addConsultation(consultation);
        consultationServiceImp.addConsultation(consultation1);
        consultationServiceImp.addConsultation(consultation2);
        List<Consultation> listConsultation = consultationRepo.findAll();
        Assertions.assertThat(listConsultation.size()).isEqualTo(3);
    }
    @Test
    public void deleteConsultationTest(){
        List<Consultation> listConsultation = addThreeConsultation();
        consultationServiceImp.deleteConsultation(listConsultation.get(1).getId());
        listConsultation = consultationRepo.findAll();
        Assertions.assertThat(listConsultation.size()).isEqualTo(2);
    }
    @Test
    public void findConsultationByIdTest(){

        List<Consultation> listConsultation = addThreeConsultation();
        Consultation consultation= consultationServiceImp.findConsultationById(listConsultation.get(1).getId());
    Assertions.assertThat(consultation.getId()).isEqualTo(listConsultation.get(1).getId());
        Assertions.assertThat(consultation.getMedicament()).isEqualTo(listConsultation.get(1).getMedicament());
    }
    @Test
    public void updateConsultationTest(){
        List<Consultation> listConsultation = addThreeConsultation();
        Consultation consultation= consultationServiceImp.findConsultationById(listConsultation.get(1).getId());
        consultation.setObservation("obsUpdate1");
        consultationServiceImp.addConsultation(consultation);
        listConsultation = consultationServiceImp.findAllConsultation();
        Assertions.assertThat(listConsultation.get(1).getObservation()).isEqualTo("obsUpdate1");
    }
}
