package com.example.task05;

public class Salary implements MailConsumer<Integer> {
    private String company;
    private String employee;
    private Integer salary;

    public Salary(String company, String employee, Integer salary) {
        this.company = company;
        this.employee = employee;
        this.salary = salary;
    }

    @Override
    public String getTo() {
        return employee;
    }

    @Override
    public Integer getContent() {
        return salary;
    }

    public String getCompany() {
        return company;
    }
}
