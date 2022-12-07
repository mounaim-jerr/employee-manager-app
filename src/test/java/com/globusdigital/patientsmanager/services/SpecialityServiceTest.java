package com.globusdigital.patientsmanager.services;

import com.globusdigital.patientsmanager.exception.UserNotFoundException;
import com.globusdigital.patientsmanager.model.Department;
import com.globusdigital.patientsmanager.model.Speciality;
import com.globusdigital.patientsmanager.repo.*;
import com.globusdigital.patientsmanager.service.DepartmentServiceImp;
import com.globusdigital.patientsmanager.service.SpecialityServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SpecialityServiceTest {
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
    public void addSpecialityTest(){
        Department department = new Department();
        department.setDepartmentName("department");
        departmentServiceImp.addDepartment(department);
        Speciality speciality = new Speciality();
        speciality.setSpecialityName("cardiologie");
        speciality.setDepartmentOfTheSpeciality(department);
        speciality = specialityServiceImp.addSpeciality(speciality);
        Assertions.assertThat(speciality).isNotNull();
        Assertions.assertThat(speciality.getSpecialityName()).isEqualTo("cardiologie");
    }
    @Test
    public  void deleteSpecialityTest(){
        Department department = new Department();
        department.setDepartmentName("department");
        departmentServiceImp.addDepartment(department);
        Speciality speciality = new Speciality();
        speciality.setSpecialityName("cardiologie");
        speciality.setDepartmentOfTheSpeciality(department);
        speciality= specialityServiceImp.addSpeciality(speciality);
        Long id = speciality.getId();
        specialityServiceImp.deleteSpeciality(id);
        Speciality finalSpeciality = speciality;
        Assertions.assertThatThrownBy(()->{
            specialityServiceImp.findSpecialityById( finalSpeciality.getId());
        }).isInstanceOf(UserNotFoundException.class);
    }
    @Test
    public void findSpecialityByNameTest(){
        Department department = new Department();
        department.setDepartmentName("department");
        departmentServiceImp.addDepartment(department);
        Speciality speciality = new Speciality();
        Speciality speciality1 = new Speciality();
        Speciality speciality2 = new Speciality();
        Speciality speciality3 = new Speciality();
        Speciality speciality4 = new Speciality();
        speciality.setDepartmentOfTheSpeciality(department);
        speciality1.setDepartmentOfTheSpeciality(department);
        speciality2.setDepartmentOfTheSpeciality(department);
        speciality3.setDepartmentOfTheSpeciality(department);
        speciality4.setDepartmentOfTheSpeciality(department);
        speciality.setSpecialityName("cardiologie");
        speciality1.setSpecialityName("gynécologie");
        speciality2.setSpecialityName("ophtalmologie");
        speciality3.setSpecialityName("psychiatrie");
        speciality4.setSpecialityName("psydo");
        specialityServiceImp.addSpeciality(speciality);
        specialityServiceImp.addSpeciality(speciality1);
        specialityServiceImp.addSpeciality(speciality2);
        specialityServiceImp.addSpeciality(speciality3);
        specialityServiceImp.addSpeciality(speciality4);
        List<Speciality> specialityFound = specialityServiceImp.findSpecialityByName("psy");
        Assertions.assertThat(specialityFound.size()).isEqualTo(2);
    }
}
