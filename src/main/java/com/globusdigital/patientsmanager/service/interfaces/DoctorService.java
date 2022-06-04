package com.globusdigital.patientsmanager.service.interfaces;

import com.globusdigital.patientsmanager.model.Doctor;


public interface DoctorService {
    Doctor addDoctor(Doctor doctor);
    Doctor updateDoctor(Doctor doctor );
    void deleteDoctor(Long id);
    Doctor findDoctorById(Long id);

    Doctor findDoctorByName(String name);

}
