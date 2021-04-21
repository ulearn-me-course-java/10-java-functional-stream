package com.example.task05;

public class Salary implements IMessage<Integer> {

    private final String company;
    private final String employee;
    private final int salary;

    public Salary(String company, String employee, int salary) {
        this.company = company;
        this.employee = employee;
        this.salary = salary;
    }

    @Override
    public String getFrom() {
        return company;
    }

    @Override
    public String getTo() {
        return employee;
    }

    @Override
    public Integer getContent() {
        return salary;
    }


}