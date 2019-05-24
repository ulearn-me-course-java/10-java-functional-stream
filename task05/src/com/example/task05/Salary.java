package com.example.task05;

public class Salary implements IMessage<Integer> {

    private String from;
    private String to;
    private int salaryValue;

    @Override
    public String getFrom() { return from; }

    @Override
    public String getTo() { return to; }

    @Override
    public Integer getContent() { return salaryValue;  }

    public Salary(String companyName, String employee, int salaryValue) {
        from = companyName;

        to = employee;

        this.salaryValue = salaryValue;
    }
}
