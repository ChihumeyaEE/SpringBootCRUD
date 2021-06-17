package com.example.SpringBootCRUD.Repository;

import com.example.SpringBootCRUD.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}