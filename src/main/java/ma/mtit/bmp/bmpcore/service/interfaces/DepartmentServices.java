package ma.mtit.bmp.bmpcore.service.interfaces;

import ma.mtit.bmp.bmpcore.model.Department;

import java.util.List;

public interface DepartmentServices {
    Department addDepartment(Department department);
    Department updateDepartment(Department department);
    Department findDepartmentById(Long id);
    void deleteDepartment(Long id);
    List<Department> findDepartmentByName(String name);
    List<Department> findAllDepartments();
}
