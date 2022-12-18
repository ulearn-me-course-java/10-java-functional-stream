package com.example.task05;

public class Salary {
    String company;
    String person;
    Integer salary;
    public Salary(String company, String person, Integer salary){
        this.company = company;
        this.salary = salary;
        this.person = person;
    }
    public String getTo(){
        return person;
    }
    public Integer getSalary(){
        return salary;
    }
}
