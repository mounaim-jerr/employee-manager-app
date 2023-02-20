package ma.mtit.bmp.bmpcore.service;

import ma.mtit.bmp.bmpcore.exception.UserNotFoundException;
import ma.mtit.bmp.bmpcore.model.Speciality;
import ma.mtit.bmp.bmpcore.repo.SpecialityRepo;
import ma.mtit.bmp.bmpcore.service.interfaces.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImp implements SpecialityService {
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
    @Override
    public List<Speciality> findAllSpeciality(){
        return specialityRepo.findAll();
    }
    @Override
    public Speciality updateSpeciality(Speciality speciality){
        return specialityRepo.save(speciality);
    }

}
