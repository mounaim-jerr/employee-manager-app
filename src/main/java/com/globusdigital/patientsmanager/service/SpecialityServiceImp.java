package com.globusdigital.patientsmanager.service;

import com.globusdigital.patientsmanager.exception.UserNotFoundException;
import com.globusdigital.patientsmanager.model.Speciality;
import com.globusdigital.patientsmanager.repo.SpecialityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImp implements  SpecialityService{
    private final SpecialityRepo specialityRepo;
    @Autowired
    public SpecialityServiceImp(SpecialityRepo specialityRepo) {
        this.specialityRepo = specialityRepo;
    }
    @Override
    public Speciality addSpeciality(Speciality speciality){
        return specialityRepo.save(speciality);
    }
    @Override
    public void deleteSpeciality(Long id){
        specialityRepo.deleteById(id);
    }
    @Override
    public Speciality findSpecialityById(Long id){
        return specialityRepo.findSpecialitiesById(id).orElseThrow(() -> new UserNotFoundException("speciality by id " + id + "was not found"));

    }
    @Override
   public List<Speciality> findSpecialityByName(String name){
        return specialityRepo.findByNameContaining(name);
    }

}
