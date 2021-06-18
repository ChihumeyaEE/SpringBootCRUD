package com.example.SpringBootCRUD.Service;

import com.example.SpringBootCRUD.Entity.Employee;
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

    public Employee createEmployee(Employee employees){
        return employeeRepository.save(employees);
    }

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
    public void updateEmployeeDetails(int employeeID, int deptID) {
        Employee employee= employeeRepository.findById(employeeID).orElseThrow(() -> new IllegalStateException(
                "student with id " + employeeID +" does not exist"));

        if(deptID != 0 && !Objects.equals(employee.getDeptID(), deptID)){
            employee.setDeptID(deptID);
        }

    }


    public String deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
        return "User got deleted";
    }

    }

