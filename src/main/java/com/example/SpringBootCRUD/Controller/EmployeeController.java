package com.example.SpringBootCRUD.Controller;

import com.example.SpringBootCRUD.Entity.Employee;
import com.example.SpringBootCRUD.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){  //Receives JSON Data
        return employeeService.createEmployee(employee);
    }

    @PostMapping("/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees ){
        return employeeService.createEmployees(employees);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeebyId(@PathVariable int id){
        return employeeService.getEmployeebyId(id);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return employee;

    }

    @PutMapping("/updateEmployeeDept/{employeeID}/{deptID}")
    public void updateEmployeeDept(@PathVariable("employeeID") int employeeID, @PathVariable int deptID){
        employeeService.updateEmployeeDetails(employeeID,deptID);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployeeById(id);
    }
}
