package com.globusdigital.patientsmanager.services;

import com.globusdigital.patientsmanager.exception.UserNotFoundException;
import com.globusdigital.patientsmanager.model.Speciality;
import com.globusdigital.patientsmanager.repo.SpecialityRepo;
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
    SpecialityServiceImp specialityServiceImp;
    @Autowired
    SpecialityRepo specialityRepo;
    @BeforeEach
    public void initContext(){
        specialityRepo.deleteAll();
    }
    @Test
    public void addSpecialityTest(){
        Speciality speciality = new Speciality();
        speciality.setSpecialityName("cardiologie");
        speciality = specialityServiceImp.addSpeciality(speciality);
        Assertions.assertThat(speciality).isNotNull();
        Assertions.assertThat(speciality.getSpecialityName()).isEqualTo("cardiologie");
    }
    @Test
    public  void deleteSpecialityTest(){
        Speciality speciality = new Speciality();
        speciality.setSpecialityName("cardiologie");
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
        Speciality speciality = new Speciality();
        Speciality speciality1 = new Speciality();
        Speciality speciality2 = new Speciality();
        Speciality speciality3 = new Speciality();
        Speciality speciality4 = new Speciality();
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
