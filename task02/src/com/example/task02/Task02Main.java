package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {


        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);


    }

    public static IntStream cycleGrayCode(int n) {
        if (n>16 || n<1){
            throw new IllegalArgumentException();
        }
        //побитовый сдвиг на один(вправо) и логическое или XOR
        return IntStream
                .iterate(0, par -> par+1)
                .map(par -> par % (int)Math.pow(2, n))
                .map(par -> par^(par>>1));
    }

}
