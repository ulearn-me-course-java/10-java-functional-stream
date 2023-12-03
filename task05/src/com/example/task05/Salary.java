package com.example.task05;

public class Salary extends Message<Integer> {
    public Salary(String companyName, String workerName, int salary) {
        super(companyName, workerName, salary);
    }
}
