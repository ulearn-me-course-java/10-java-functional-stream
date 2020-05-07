package com.example.task05;

public class Salary  implements Message<Integer>{
    private String company_name;
    private String employee_name;
    private int salary;

    public Salary(String company_name, String employee_name, int salary) {
        this.company_name = company_name;
        this.employee_name = employee_name;
        this.salary = salary;
    }

    @Override
    public String getFrom() {
        return company_name;
    }

    @Override
    public String getTo() {
        return employee_name;
    }

    @Override
    public Integer getContent() {
        return salary;
    }
}
