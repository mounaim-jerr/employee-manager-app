package com.globusdigital.employeemanager.repo;

import com.globusdigital.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee , Long> {
    void deleteEmployeesById(Long id);
    Optional<Employee> findEmployeeById(Long id);
}
