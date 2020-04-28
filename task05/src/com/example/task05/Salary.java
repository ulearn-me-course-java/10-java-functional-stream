package com.example.task05;

public class Salary implements MailContainer <Integer> {

    private String organisation;

    private String person;

    private Integer salary;

    public Salary(String organisation, String person, Integer salary) {
        this.organisation = organisation;
        this.person = person;
        this.salary = salary;
    }

    @Override
    public String getTo() {
        return person;
    }

    @Override
    public Integer getMessage() {
        return salary;
    }
}
