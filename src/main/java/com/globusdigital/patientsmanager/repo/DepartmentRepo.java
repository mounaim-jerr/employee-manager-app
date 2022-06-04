package com.globusdigital.patientsmanager.repo;

import com.globusdigital.patientsmanager.model.Department;
import com.globusdigital.patientsmanager.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
    Optional<Department> findDepartmentsById(Long id);
    List<Department> findByDepartmentNameContaining(String name);
}
