package se.yrgo.domain;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SALARY")
    private int salary;

    @Column(name = "EMP_ID")
    private String employeeId;

    public Employee() {
    }

    public Employee(String name, int salary, String employeeId) {
        this.name = name;
        this.salary = salary;
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return String.format("Emp. ID: %s - Name: %s - Salary: %d", employeeId, name, salary);
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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

}
