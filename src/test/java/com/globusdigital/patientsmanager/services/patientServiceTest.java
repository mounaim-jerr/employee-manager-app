package com.globusdigital.patientsmanager.services;

import com.globusdigital.patientsmanager.exception.UserNotFoundException;
import com.globusdigital.patientsmanager.model.Patient;
import com.globusdigital.patientsmanager.service.PatientService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class patientServiceTest {
    @Autowired
    PatientService patientService ;
    @Test
    public void addPatientTest(){
        Patient patient = new Patient();
        patient.setName("jerroudi abdelmonaim");
        patient.setCin("FA171492");
        patient.setEmail("jerroudi.mo@gmail.com");
        patient= patientService.addPatient(patient);
        Assertions.assertThat(patient).isNotNull();
        Assertions.assertThat(patient.getId()).isNotNull();
        Assertions.assertThat(patient.getName()).isEqualTo("jerroudi abdelmonaim");
        Assertions.assertThat(patient.getCin()).isEqualTo("FA171492");
        Assertions.assertThat(patient.getEmail()).isEqualTo("jerroudi.mo@gmail.com");
        Assertions.assertThat(patient.getPatientCode()).isNotNull();
    }
    @Test
    public void deletePatientTest(){
        Patient patient = new Patient();
        patient.setName("jerroudi abdelmonaim");
        patient.setCin("FA171492");
        patient.setEmail("jerroudi.mo@gmail.com");
        patient = patientService.addPatient(patient);
        patientService.deletePatient(patient.getId());

        Patient finalPatient = patient;
        Assertions.assertThatThrownBy(()->{
            patientService.findPatientById( finalPatient.getId());
        }).isInstanceOf(UserNotFoundException.class);
    }
    @Test
    public void updateAndFindByIdPatientTest(){
        Patient patient = new Patient();

        patient.setName("mohammed zgheli");
        patient.setEmail("mohammed.je@gmail.com");
        patient.setCin("FA121314");
        patient.setPhone("0607080910");
        patient = patientService.addPatient(patient);
        Long id = patient.getId();
        patient.setPhone("0000000000");
        patient.setCin("FA000000");
        patient.setEmail("mohammed.mo@gmail.com");
        patient.setName("mohammed jerroudi");
        patient = patientService.updatePatient(patient);
        Assertions.assertThat(patient.getId()).isEqualTo(id);
        patient = patientService.findPatientById(patient.getId());
        Assertions.assertThat(patient.getName()).isEqualTo("mohammed jerroudi");
    }
    @Test
    public void deleteAllAndFindAllPatients(){
        Patient patient = new Patient();
        Patient patient1 = new Patient();
        patientService.deleteAllPatients();
        List<Patient> findPatients = patientService.findAllPatients();
        Assertions.assertThat(findPatients.size()).isEqualTo(0);
        patient.setCin("123123");
        patientService.addPatient(patient);
        findPatients = patientService.findAllPatients();
        Assertions.assertThat(findPatients.size()).isEqualTo(1);
        patient1.setCin("121212");
        patientService.addPatient(patient1);
        findPatients = patientService.findAllPatients();
        Assertions.assertThat(findPatients.size()).isEqualTo(2);
        patientService.deleteAllPatients();
        findPatients = patientService.findAllPatients();
        Assertions.assertThat(findPatients.size()).isEqualTo(0);
    }
}
