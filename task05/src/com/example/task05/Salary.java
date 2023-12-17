package com.example.task05;

public class Salary extends AbstractMessage<Integer> {

    private final int content;

    @Override
    public Integer getContent() {
        return content;
    }

    public Salary(String from, String to, int content) {
        super(from, to);
        this.content = content;
    }
}
