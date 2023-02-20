package ma.mtit.bmp.bmpcore.repo;

import ma.mtit.bmp.bmpcore.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findDoctorById(Long id);

   List<Doctor> findByNameContaining(String name);

}
