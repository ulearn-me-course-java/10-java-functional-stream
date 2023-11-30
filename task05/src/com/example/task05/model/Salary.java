
package com.example.task05.model;

public class Salary implements Message<Integer> {
    private String from;
    private String to;
    private Integer content;

    public Salary(String from, String to, Integer content) {
        this.from = from;
        this.to = to;
        this.content = content;
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
        return content;
    }
}
