package com.globusdigital.patientsmanager.service.interfaces;


import com.globusdigital.patientsmanager.model.Speciality;

import java.util.List;

public interface SpecialityService {
    Speciality addSpeciality(Speciality speciality);
    void deleteSpeciality(Long id);
    Speciality findSpecialityById(Long id);
    List<Speciality> findSpecialityByName(String name);
    List<Speciality> findAllSpeciality();
    Speciality updateSpeciality(Speciality speciality);
}
