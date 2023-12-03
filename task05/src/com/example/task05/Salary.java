package com.example.task05;

public class Salary implements IEntry<Integer> {
    private String from;
    private String to;
    private Integer amount;
    public Salary(String from, String to, Integer amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
    public String getFrom() {
        return  from;
    }

    public String getTo() {
        return to;
    }

    public Integer getContent() {
        return amount;
    }
}
