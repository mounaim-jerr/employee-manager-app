package com.globusdigital.patientsmanager.services;

import com.globusdigital.patientsmanager.exception.UserNotFoundException;
import com.globusdigital.patientsmanager.model.Department;
import com.globusdigital.patientsmanager.model.Doctor;
import com.globusdigital.patientsmanager.model.Patient;
import com.globusdigital.patientsmanager.model.Speciality;
import com.globusdigital.patientsmanager.repo.*;
import com.globusdigital.patientsmanager.service.DepartmentServiceImp;
import com.globusdigital.patientsmanager.service.SpecialityServiceImp;
import com.globusdigital.patientsmanager.service.DoctorServiceImp;
import com.globusdigital.patientsmanager.service.PatientServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {
    @Autowired
    PatientServiceImp patientServiceImp;
    @Autowired
    DoctorServiceImp doctorServiceImp;
    @Autowired
    DepartmentServiceImp departmentServiceImp;
    @Autowired
    SpecialityServiceImp specialityServiceImp;
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
    @Test
    public void addPatientTest(){
      Department department = new Department();
      department.setName("department");
      departmentServiceImp.addDepartment(department);
      Speciality speciality = new Speciality();
      speciality.setName("speciality");
      speciality.setDepartment(department);
      specialityServiceImp.addSpeciality(speciality);
        Doctor doctor = new Doctor();
        doctor.setCin("FA131313");
        doctor.setName("doctor");
        doctor.setSpeciality(speciality);
        doctor = doctorServiceImp.addDoctor(doctor);
        //==============add patient
        Patient patient = new Patient();
        patient.setName("jerroudi abdelmonaim");
        patient.setCin("FA171492");
        patient.setEmail("jerroudi.mo@gmail.com");

        patient= patientServiceImp.addPatient(patient);

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
        patient = patientServiceImp.addPatient(patient);
        patientServiceImp.deletePatient(patient.getId());
        Patient finalPatient = patient;
        Assertions.assertThatThrownBy(()->{
            patientServiceImp.findPatientById( finalPatient.getId());
        }).isInstanceOf(UserNotFoundException.class);
    }
    @Test
    public void updateAndFindByIdPatientTest(){
        Patient patient = new Patient();
        patient.setName("mohammed zgheli");
        patient.setEmail("mohammed.je@gmail.com");
        patient.setCin("FA121314");
        patient.setPhone("0607080910");
        patient = patientServiceImp.addPatient(patient);
        Long id = patient.getId();
        patient.setPhone("0000000000");
        patient.setCin("FA000000");
        patient.setEmail("mohammed.mo@gmail.com");
        patient.setName("mohammed jerroudi");
        patient = patientServiceImp.updatePatient(patient);
        Assertions.assertThat(patient.getId()).isEqualTo(id);
        patient = patientServiceImp.findPatientById(patient.getId());
        Assertions.assertThat(patient.getName()).isEqualTo("mohammed jerroudi");
    }


    @Test
    public void findAllPatient(){

        Patient patient = new Patient();
        Patient patient1 = new Patient();
        Patient patient2 = new Patient();
        patient.setCin("FA171492");
        patient1.setCin("FA123123");
        patient2.setCin("FA121212");
        patientServiceImp.addPatient(patient);
        patientServiceImp.addPatient(patient1);
        patientServiceImp.addPatient(patient2);
        List<Patient> findPatients = patientServiceImp.findAllPatients();
        Assertions.assertThat(findPatients.size()).isEqualTo(3);
    }
    @Test
    public void findPatientByNameTest(){
        Patient patient = new Patient();
        Patient patient1 = new Patient();
        Patient patient2 = new Patient();
        Patient patient3 = new Patient();
        patient.setCin("FA171492");
        patient.setName("jerroudi abdelmonaim");
        patientServiceImp.addPatient(patient);
        List<Patient> patientList = patientServiceImp.findPatientByName("jerroudi");
        Assertions.assertThat(patientList.size()).isEqualTo(1);
        patient1.setName("jerroudi mouad");
        patient1.setCin("FA121212");
        patientServiceImp.addPatient(patient1);
        patientList = patientServiceImp.findPatientByName("jerroudi");
        Assertions.assertThat(patientList.size()).isEqualTo(2);
        patient2.setName("mouad jerroudi");
        patient2.setCin("FA121212");
        patientServiceImp.addPatient(patient2);
        patientList = patientServiceImp.findPatientByName("jerroudi");
        Assertions.assertThat(patientList.size()).isEqualTo(3);
        patient3.setName("momo jerroudei");
        patient3.setCin("FA171412");
        patientServiceImp.addPatient(patient3);
        patientList = patientServiceImp.findPatientByName("jerroudi");
        Assertions.assertThat(patientList.size()).isEqualTo(3);








    }
}
