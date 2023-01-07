package com.globusdigital.patientsmanager.services;

import com.globusdigital.patientsmanager.exception.UserNotFoundException;
import com.globusdigital.patientsmanager.model.Department;
import com.globusdigital.patientsmanager.repo.*;
import com.globusdigital.patientsmanager.service.DepartmentServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DepartmentServiceTest {
    @Autowired
    DepartmentServiceImp departmentServiceImp;
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
    public void addDepartmentTest() {
        Department department = new Department();
        department.setName("departmentone");
        department = departmentServiceImp.addDepartment(department);
        Assertions.assertThat(department).isNotNull();
        Assertions.assertThat(department.getName()).isEqualTo("departmentone");
    }

    @Test
    public void deleteDepartmentTest() {
        Department department = new Department();
        department.setName("departementone");
        department = departmentServiceImp.addDepartment(department);
        Long id = department.getId();
        departmentServiceImp.deleteDepartment(id);

        Assertions.assertThatThrownBy(() -> {
            departmentServiceImp.findDepartmentById(id);
        }).isInstanceOf(UserNotFoundException.class);
    }

    @Test
    public void findDepartmentByNameTest() {
        Department department1 = new Department();
        Department department = new Department();
        Department department2 = new Department();
        department.setName("departmentone");
        department1.setName("departmenttwo");
        department2.setName("departmentthee");
        departmentServiceImp.addDepartment(department);
        departmentServiceImp.addDepartment(department1);
        departmentServiceImp.addDepartment(department2);
        List<Department> departmentsFound = departmentServiceImp.findDepartmentByName("department");
        Assertions.assertThat(departmentsFound.size()).isEqualTo(3);
        departmentsFound = departmentServiceImp.findDepartmentByName("departmento");
        Assertions.assertThat(departmentsFound.size()).isEqualTo(1);
        departmentsFound = departmentServiceImp.findDepartmentByName("jerroudi");
        Assertions.assertThat(departmentsFound.size()).isEqualTo(0);
    }
}
