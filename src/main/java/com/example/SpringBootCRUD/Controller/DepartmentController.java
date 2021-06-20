package com.example.SpringBootCRUD.Controller;

import com.example.SpringBootCRUD.Entity.Department;
import com.example.SpringBootCRUD.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department){  //Receives JSON Data
        return departmentService.createDepartment(department);
    }

    @PostMapping("/addDepartments")
    public List<Department> addDepartments(@RequestBody List<Department> departments ){
        return departmentService.createDepartments(departments);
    }

    @GetMapping("/{id}")
    public Department getDepartmentbyId(@PathVariable int id){
        return getDepartmentbyId(id);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentService.getDepartments();
    }

    @PutMapping("/update")
    public Department updateDepartment(@RequestBody Department department){
        departmentService.updateDepartment(department);
        return department;

    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable int id){
        return departmentService.deleteDepartmentById(id);
    }
}
