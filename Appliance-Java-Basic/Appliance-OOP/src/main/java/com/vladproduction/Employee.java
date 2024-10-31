package com.vladproduction;

public class Employee extends User {

    private String department;

    public Employee(long id, String name, String email, String password, String department) {
        super(id, name, email, password);
        this.department = department;
    }

    public Employee() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                ", department='" + getDepartment() + '\'' +
                '}';
    }
}
