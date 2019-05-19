package com.example.task05;

public class Salary implements IFromToContent<Integer>{
    private String from, to;
    private Integer salary;

    public Salary(String from, String to, int salary) {
        this.from = from;
        this.to = to;
        this.salary = salary;
    }

    @Override
    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public Integer getContent() {
        return salary;
    }
}
