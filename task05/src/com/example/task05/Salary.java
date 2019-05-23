package com.example.task05;

public class Salary implements IMessage<Integer> {

    private String _from;
    private String _to;
    private int _salaryValue;

    @Override
    public String getFrom() { return _from; }

    @Override
    public String getTo() { return _to; }

    @Override
    public Integer getContent() { return _salaryValue;  }

    public Salary(String companyName, String employee, int salaryValue) {
        _from = companyName;

        _to = employee;

        _salaryValue = salaryValue;
    }
}
