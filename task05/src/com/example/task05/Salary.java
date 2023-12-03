package com.example.task05;

public class Salary extends MailForm<Integer> {
    private final int salary;

    public Salary(String from, String to, int salary) {
        super(from, to);
        this.salary = salary;
    }

    @Override
    public Integer getContent() {
        return salary;
    }
}
