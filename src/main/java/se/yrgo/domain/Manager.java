package se.yrgo.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SALARY")
    private int salary;

    @OneToMany
    @JoinColumn(name = "MANAGER_FK")
    private List<Employee> employees;

    public Manager() {
    }

    public Manager(String name, int salary) {
        this.name = name;
        this.salary = salary;
        employees = new ArrayList<>();
    }

    public void addEmployeeToList(Employee e) {
        employees.add(e);
    }

    public List<Employee> getEmployeeList() {
        return Collections.unmodifiableList(employees);
    }

    @Override
    public String toString() {
        return String.format("Name: %s - Salary: %d", name, salary);
    }

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
