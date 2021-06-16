package com.example.SpringBootCRUD.Repository;

import com.example.SpringBootCRUD.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
