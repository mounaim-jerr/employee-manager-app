package ma.mtit.bmp.bmpcore.controllers;

import ma.mtit.bmp.bmpcore.model.Speciality;
import ma.mtit.bmp.bmpcore.service.interfaces.SpecialityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {
    private final SpecialityService specialityServiceImp;

    public SpecialityController(SpecialityService specialityServiceImp) {
        this.specialityServiceImp = specialityServiceImp;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Speciality>> getAllSpecialities(){
        List<Speciality> specialityList = specialityServiceImp.findAllSpeciality();
        return new ResponseEntity<>(specialityList, HttpStatus.OK);
    }
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Speciality> getSpecialityById(@PathVariable("id") Long id){
        Speciality speciality = specialityServiceImp.findSpecialityById(id);
        return new ResponseEntity<>(speciality, HttpStatus.OK);
    }
    @GetMapping("/find/name/{name}")
    public ResponseEntity<List<Speciality>> getSpecialitiesByName(@PathVariable ("name") String name){
        List<Speciality> specialities = specialityServiceImp.findSpecialityByName(name);
        return new ResponseEntity<>(specialities, HttpStatus.OK);

    }
    @PostMapping("/add")
    public ResponseEntity<Speciality> addSpeciality(@RequestBody Speciality speciality){
        Speciality newSpeciality = specialityServiceImp.addSpeciality(speciality);
        return new ResponseEntity<>(newSpeciality , HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Speciality> updateSpeciality(@RequestBody Speciality speciality){
        Speciality updateSpeciality = specialityServiceImp.updateSpeciality(speciality);
        return new ResponseEntity<>(updateSpeciality, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSpeciality(@PathVariable ("id") Long id){
        specialityServiceImp.deleteSpeciality(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
