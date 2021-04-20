package com.example.task05;

public class Salary<T> implements IMessage<T>{
    String company;
    String name;
    T salary;

    public Salary(String c, String n, T s){
        company= c;
        name = n;
        salary = s;
    }

    @Override
    public String getFrom() {
        return company;
    }

    @Override
    public String getTo() {
        return name;
    }

    @Override
    public T getContent() {
        return salary;
    }
}
