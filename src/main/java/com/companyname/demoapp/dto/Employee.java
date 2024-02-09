package com.companyname.demoapp.dto;

public class Employee implements Comparable<Employee> {
    private Integer id;
    private String name;
    private Double salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
    }

    @Override
    public int compareTo(Employee employee) {
        return this.id.compareTo(employee.getId());
    }
}
