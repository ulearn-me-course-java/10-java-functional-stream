package com.example.task05;

public class Salary implements IMessage<Integer> {

    private int salary;
    private String company;
    private String employe;


    public Salary(String company, String employee, int salary) {
        this.company = company;
        this.employe = employee;
        this.salary = salary;
    }
    @Override
    public String getFrom() { return company; }

    @Override
    public String getTo() { return employe; }

    @Override
    public Integer getContent() { return salary;  }


}