package com.globusdigital.patientsmanager.services;

import com.globusdigital.patientsmanager.exception.UserNotFoundException;
import com.globusdigital.patientsmanager.model.Department;
import com.globusdigital.patientsmanager.model.Doctor;
import com.globusdigital.patientsmanager.model.Speciality;
import com.globusdigital.patientsmanager.repo.*;
import com.globusdigital.patientsmanager.service.DepartmentServiceImp;
import com.globusdigital.patientsmanager.service.DoctorServiceImp;
import com.globusdigital.patientsmanager.service.SpecialityServiceImp;
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
public void findDoctorByName(){
    List<Doctor> doctorFind ;
    Department department = new Department();
    department.setName("departement");
    departmentServiceImp.addDepartment(department);
    Speciality speciality = new Speciality();
    speciality.setName("cardio");
    speciality.setDepartment(department);
    specialityServiceImp.addSpeciality(speciality);
    Doctor doctor = new Doctor();
    Doctor doctor1 = new Doctor();
    Doctor doctor2 = new Doctor();
    doctor.setSpeciality(speciality);
    doctor1.setSpeciality(speciality);
    doctor2.setSpeciality(speciality);
    doctor.setCin("FA171412");
    doctor.setName("momo");
    doctor1.setCin("FA121312");
    doctor1.setName("mounaim");
    doctor2.setCin("FA131313");
    doctor2.setName("moumen");
    doctor =  doctorServiceImp.addDoctor(doctor);
    doctor1= doctorServiceImp.addDoctor(doctor1);
    doctor2= doctorServiceImp.addDoctor(doctor2);
    doctorFind = doctorServiceImp.findDoctorByName("momo");
    Assertions.assertThat(doctorFind.size()).isEqualTo(1);
    Assertions.assertThat(doctorFind.get(0).getName()).isEqualTo("momo");

}
@Test
    public void addDoctorTest(){
    Department department = new Department();
    department.setName("department");
    departmentServiceImp.addDepartment(department);
    Speciality speciality = new Speciality();
    speciality.setName("speciality");
    speciality.setDepartment(department);
    specialityServiceImp.addSpeciality(speciality);
    Doctor doctor = new Doctor();
    doctor.setCin("FA171493");
    doctor.setSpeciality(speciality);
    doctor = doctorServiceImp.addDoctor(doctor);
    Assertions.assertThat(doctor.getCin()).isEqualTo("FA171493");
    }
    @Test
    public void updateDoctorTest(){
        Department department = new Department();
        department.setName("department");
        departmentServiceImp.addDepartment(department);
        Speciality speciality = new Speciality();
        speciality.setName("speciality");
        speciality.setDepartment(department);
        specialityServiceImp.addSpeciality(speciality);
    Doctor doctor = new Doctor();
    doctor.setCin("FA171493");
    doctor.setSpeciality(speciality);
    doctor = doctorServiceImp.addDoctor(doctor);
    Long id = doctor.getId();
    doctor.setCin("FA121212");
    doctor = doctorServiceImp.updateDoctor(doctor);
    Assertions.assertThat(doctor.getId()).isEqualTo(id);
    doctor = doctorServiceImp.findDoctorById(doctor.getId());
    Assertions.assertThat(doctor.getCin()).isEqualTo("FA121212");
    }
    @Test
    public void deleteDoctorTest(){
        Department department = new Department();
        department.setName("department");
        departmentServiceImp.addDepartment(department);
        Speciality speciality = new Speciality();
        speciality.setName("speciality");
        speciality.setDepartment(department);
        specialityServiceImp.addSpeciality(speciality);
    Doctor doctor = new Doctor();
    doctor.setCin("FA171492");
    doctor.setSpeciality(speciality);
    doctor= doctorServiceImp.addDoctor(doctor);
    doctorServiceImp.deleteDoctor(doctor.getId());
    Doctor finalDoctor = doctor;
        Assertions.assertThatThrownBy(()->{
            doctorServiceImp.findDoctorById( finalDoctor.getId());
        }).isInstanceOf(UserNotFoundException.class);
    }


}
