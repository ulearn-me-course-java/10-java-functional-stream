package com.example.task05;

public class Salary extends Message<Integer> {
    public Salary(String company, String employeeFullName, int salary){
        super(company, employeeFullName, salary);
    }
}
