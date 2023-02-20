package ma.mtit.bmp.bmpcore.services;

import ma.mtit.bmp.bmpcore.exception.UserNotFoundException;
import ma.mtit.bmp.bmpcore.repo.*;
import ma.mtit.bmp.bmpcore.model.Department;
import ma.mtit.bmp.bmpcore.model.Speciality;
import ma.mtit.bmp.bmpcore.service.DepartmentServiceImp;
import ma.mtit.bmp.bmpcore.service.SpecialityServiceImp;
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
        department.setName("department");
        departmentServiceImp.addDepartment(department);
        Speciality speciality = new Speciality();
        speciality.setName("cardiologie");
        speciality.setDepartment(department);
        speciality = specialityServiceImp.addSpeciality(speciality);
        Assertions.assertThat(speciality).isNotNull();
        Assertions.assertThat(speciality.getName()).isEqualTo("cardiologie");
    }
    @Test
    public  void deleteSpecialityTest(){
        Department department = new Department();
        department.setName("department");
        departmentServiceImp.addDepartment(department);
        Speciality speciality = new Speciality();
        speciality.setName("cardiologie");
        speciality.setDepartment(department);
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
        department.setName("department");
        departmentServiceImp.addDepartment(department);
        Speciality speciality = new Speciality();
        Speciality speciality1 = new Speciality();
        Speciality speciality2 = new Speciality();
        Speciality speciality3 = new Speciality();
        Speciality speciality4 = new Speciality();
        speciality.setDepartment(department);
        speciality1.setDepartment(department);
        speciality2.setDepartment(department);
        speciality3.setDepartment(department);
        speciality4.setDepartment(department);
        speciality.setName("cardiologie");
        speciality1.setName("gynécologie");
        speciality2.setName("ophtalmologie");
        speciality3.setName("psychiatrie");
        speciality4.setName("psydo");
        specialityServiceImp.addSpeciality(speciality);
        specialityServiceImp.addSpeciality(speciality1);
        specialityServiceImp.addSpeciality(speciality2);
        specialityServiceImp.addSpeciality(speciality3);
        specialityServiceImp.addSpeciality(speciality4);
        List<Speciality> specialityFound = specialityServiceImp.findSpecialityByName("psy");
        Assertions.assertThat(specialityFound.size()).isEqualTo(2);
    }
}
