package ma.mtit.bmp.bmpcore.controllers;

import ma.mtit.bmp.bmpcore.model.Department;
import ma.mtit.bmp.bmpcore.service.interfaces.DepartmentServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServices departmentServicesImp;

    public DepartmentController(DepartmentServices departmentServicesImp) {
        this.departmentServicesImp = departmentServicesImp;
    }
  @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> departments = departmentServicesImp.findAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
  }
  @GetMapping("/find/id/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long id){
        Department department = departmentServicesImp.findDepartmentById(id);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }
    @GetMapping("/find/name/{name}")
            public ResponseEntity<List<Department>> findDepartmentByName(@PathVariable("name") String name){
        List<Department> departments = departmentServicesImp.findDepartmentByName(name);
        return new ResponseEntity<>(departments,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        Department newDepartment = departmentServicesImp.addDepartment(department);
        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department){
        Department updateDepartment = departmentServicesImp.updateDepartment(department);
        return new ResponseEntity<>(updateDepartment, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable ("id") Long id){
        departmentServicesImp.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
