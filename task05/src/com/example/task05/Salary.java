package com.example.task05;

import java.util.List;
import java.util.function.Consumer;

public class Salary implements Mail<Integer>
{
    private String from;
    private String to;
    private Integer pay;

    public Salary(String from, String to, Integer pay)
    {
        this.from = from;
        this.to = to;
        this.pay = pay;
    }

    @Override
    public String getFrom()
    {
        return from;
    }

    public String getTo()
    {
        return to;
    }

    @Override
    public Integer getContent()
    {
        return pay;
    }

}
