package com.example.SpringBootCRUD.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int salary_min_range;
    private int salary_max_range;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary_min_range() {
        return salary_min_range;
    }

    public void setSalary_min_range(int salary_min_range) {
        this.salary_min_range = salary_min_range;
    }

    public int getSalary_max_range() {
        return salary_max_range;
    }

    public void setSalary_max_range(int salary_max_range) {
        this.salary_max_range = salary_max_range;
    }
}
