package com.example.task05;

import org.assertj.core.util.diff.Delta;

public class Salary extends Server<Integer> {
    public Salary(String company, String to, int salary) {
        super(company, to, salary);
    }
}
