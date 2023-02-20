package ma.mtit.bmp.bmpcore.service.interfaces;

import ma.mtit.bmp.bmpcore.model.Doctor;

import java.util.List;


public interface DoctorService {
    Doctor addDoctor(Doctor doctor);
    Doctor updateDoctor(Doctor doctor );
    void deleteDoctor(Long id);
    Doctor findDoctorById(Long id);

    List<Doctor> findDoctorByName(String name);

    List<Doctor> findAllDoctors();

}
