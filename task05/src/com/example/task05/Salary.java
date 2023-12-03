package com.example.task05;

public class Salary implements Message<Integer> {
    private final String from;

    @Override
    public String getFrom(){
        return from;
    }

    private final String to;

    @Override
    public String getTo() {
        return to;
    }

    private final Integer salary;
    @Override
    public Integer getContent() {
        return salary;
    }

    public Salary(String from, String to, Integer salary){
        this.from = from;
        this.to = to;
        this.salary = salary;
    }
}
