package com.example.task05;

public class Salary implements MailServiceElement<Integer> {
    private final String from, to;
    private final Integer value;

    public Salary(String from, String to, Integer value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public Integer getContent() {
        return value;
    }
}
