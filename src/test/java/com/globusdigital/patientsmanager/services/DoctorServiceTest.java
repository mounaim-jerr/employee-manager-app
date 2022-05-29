package com.globusdigital.patientsmanager.services;

import com.globusdigital.patientsmanager.exception.UserNotFoundException;
import com.globusdigital.patientsmanager.model.Doctor;
import com.globusdigital.patientsmanager.repo.DoctorRepo;
import com.globusdigital.patientsmanager.service.DoctorService;
import com.globusdigital.patientsmanager.service.DoctorServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DoctorServiceTest {
@Autowired
    DoctorServiceImp doctorServiceImp;
@Autowired
    DoctorRepo doctorRepo;
@BeforeEach
public void initContext(){
    doctorRepo.deleteAll();
}
@Test
public void findDoctorByName(){
    Doctor doctorFind ;
    Doctor doctor = new Doctor();
    Doctor doctor1 = new Doctor();
    Doctor doctor2 = new Doctor();
    doctor.setDoctorCin("FA171412");
    doctor.setDoctorName("momo");
    doctor1.setDoctorCin("FA121312");
    doctor1.setDoctorName("mounaim");
    doctor2.setDoctorCin("FA131313");
    doctor2.setDoctorName("moumen");
    doctor =  doctorServiceImp.addDoctor(doctor);
    doctor1= doctorServiceImp.addDoctor(doctor1);
    doctor2= doctorServiceImp.addDoctor(doctor2);
    //doctorFind = doctorServiceImp.findDoctorByName("mo");
    //Doctor doctorFinal = doctorFind;
    //Assertions.assertThatThrownBy(()->{
      //  doctorServiceImp.findDoctorByName( doctorFinal.getDoctorName());
    //}).isInstanceOf(UserNotFoundException.class);
    doctorFind = doctorServiceImp.findDoctorByName("momo");
    Assertions.assertThat(doctorFind.getDoctorName()).isEqualTo("momo");





}
}
