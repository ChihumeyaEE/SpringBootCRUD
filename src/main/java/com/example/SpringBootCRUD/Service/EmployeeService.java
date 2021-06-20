package com.example.SpringBootCRUD.Service;

import com.example.SpringBootCRUD.Entity.Department;
import com.example.SpringBootCRUD.Entity.Employee;
import com.example.SpringBootCRUD.Repository.DepartmentRepository;
import com.example.SpringBootCRUD.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee createEmployee(Employee employees){
        return employeeRepository.save(employees);
    }
//    public Employee createEmployee(Employee employees, Integer deptID){
//        Department department= departmentRepository.findById(deptID).orElseThrow(() -> new IllegalStateException(
//                "Department with id " + deptID +" does not exist"));
//
//        return employeeRepository.save(employees);
//    }

    public List<Employee> createEmployees(List<Employee> employees){
         return employeeRepository.saveAll(employees);
    }

    public Employee getEmployeebyId(int id){
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void updateEmployee(Employee employee){

        employeeRepository.save(employee);

     }

    @Transactional
    public String updateEmployeeDetails(int employeeID, int deptID) {
        Employee employee= employeeRepository.findById(employeeID).orElseThrow(() -> new IllegalStateException(
                "Employee with id " + employeeID +" does not exist"));

        Department department= departmentRepository.findById(deptID).orElseThrow(() -> new IllegalStateException(
                "Department with id " + deptID +" does not exist"));


        if(deptID != 0 && !Objects.equals(employee.getDeptID(), deptID)){
            employee.setDeptID(deptID);
        }
        return "Details have been updated";
    }


    public String deleteEmployeeById(int id) {
        Employee employee= employeeRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Employee with id " + id +" does not exist"));

        employeeRepository.deleteById(id);
        return "User got deleted";
    }

    }

