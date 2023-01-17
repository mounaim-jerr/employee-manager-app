package com.globusdigital.patientsmanager.service;

import com.globusdigital.patientsmanager.exception.UserNotFoundException;
import com.globusdigital.patientsmanager.model.Department;
import com.globusdigital.patientsmanager.repo.DepartmentRepo;
import com.globusdigital.patientsmanager.service.interfaces.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentServices {
    private final DepartmentRepo departmentRepo;
@Autowired
    public DepartmentServiceImp(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }
    @Autowired
    public List<Department> findAllDepartments(){
    return departmentRepo.findAll();
    }
    @Override
    public Department addDepartment(Department department){
    return departmentRepo.save(department);
    }
    @Override
    public Department updateDepartment(Department department){
    return departmentRepo.save(department);
    }
    @Override
    public Department findDepartmentById(Long id){
    return  departmentRepo.findDepartmentsById(id).orElseThrow(() -> new UserNotFoundException("department by id " + id + "was not found"));
    }
    @Override
    public  void deleteDepartment(Long id){
    departmentRepo.deleteById(id);
    }
    @Override
    public List<Department> findDepartmentByName(String name){
    return  departmentRepo.findByNameContaining(name);
    }
}
