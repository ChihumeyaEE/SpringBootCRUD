package com.example.SpringBootCRUD.Service;

import com.example.SpringBootCRUD.Entity.Department;
import com.example.SpringBootCRUD.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> createDepartments(List<Department> departments){
        return departmentRepository.saveAll(departments);
    }

    public Department getDepartmentbyId(int id){
        return departmentRepository.findById(id).orElse(null);
    }

    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }

    public void updateDepartment(Department department){

        departmentRepository.save(department);

    }

    public String deleteDepartmentById(int id) {
        departmentRepository.deleteById(id);
        return "Department got deleted";
    }

}

