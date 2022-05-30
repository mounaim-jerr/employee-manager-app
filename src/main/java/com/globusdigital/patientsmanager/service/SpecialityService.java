package com.globusdigital.patientsmanager.service;

import com.globusdigital.patientsmanager.model.Patient;
import com.globusdigital.patientsmanager.model.Speciality;

import java.util.List;

public interface SpecialityService {
    Speciality addSpeciality(Speciality speciality);
    void deleteSpeciality(Long id);
    Speciality findSpecialityById(Long id);
    List<Speciality> findSpecialityByName(String name);
}
