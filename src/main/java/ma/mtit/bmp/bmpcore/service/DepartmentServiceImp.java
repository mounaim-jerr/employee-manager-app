package ma.mtit.bmp.bmpcore.service;

import ma.mtit.bmp.bmpcore.exception.UserNotFoundException;
import ma.mtit.bmp.bmpcore.repo.DepartmentRepo;
import ma.mtit.bmp.bmpcore.service.interfaces.DepartmentServices;
import ma.mtit.bmp.bmpcore.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
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
