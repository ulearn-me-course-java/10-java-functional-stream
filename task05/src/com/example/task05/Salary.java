package com.example.task05;

public class Salary implements IService<Integer> {
    private String club, player;
    private int salary;

    public Salary(String club, String player, int salary) {
        this.club = club;
        this.player = player;
        this.salary = salary;
    }

    @Override
    public Integer getContent() {
        return salary;
    }

    @Override
    public String getFrom() {
        return club;
    }

    @Override
    public String getTo() {
        return player;
    }
}
