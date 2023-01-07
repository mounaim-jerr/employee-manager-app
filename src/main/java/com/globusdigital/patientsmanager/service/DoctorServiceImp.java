package com.globusdigital.patientsmanager.service;

import com.globusdigital.patientsmanager.exception.UserNotFoundException;
import com.globusdigital.patientsmanager.model.Doctor;
import com.globusdigital.patientsmanager.repo.DoctorRepo;
import com.globusdigital.patientsmanager.service.interfaces.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorServiceImp implements DoctorService {
    private final DoctorRepo doctorRepo;

    @Autowired
    public DoctorServiceImp(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }


    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }
    @Override
    public Doctor updateDoctor(Doctor doctor ){
return doctorRepo.save(doctor);
    }
    @Override
    public void deleteDoctor(Long id){
         doctorRepo.deleteById(id);
    }
    @Override
    public Doctor findDoctorById(Long id) {
        return doctorRepo.findDoctorById(id).orElseThrow(() -> new UserNotFoundException("user by id " + id + "was not found"));
    }
    @Override
    public List<Doctor> findDoctorByName(String name){
    return  doctorRepo.findByNameContaining(name);
    }
    @Override
    public List<Doctor> findAllDoctors(){
        return doctorRepo.findAll();
    }

}
