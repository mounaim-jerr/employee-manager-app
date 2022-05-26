package com.globusdigital.employeemanager.service;

import com.globusdigital.employeemanager.exception.UserNotFoundException;
import com.globusdigital.employeemanager.model.Employee;
import com.globusdigital.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo ;
@Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
    employee.setEmployeeCode(UUID.randomUUID().toString());
    return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployees(){
    return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
    return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id){
    return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("user by id " + id + "was not found"));
    }
    public void  deleteEmployee (Long id){
    employeeRepo.deleteEmployeesById(id);
    }

}
