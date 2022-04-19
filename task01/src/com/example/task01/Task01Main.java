package com.example.task01;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task01Main {
    public static void main(String[] args) throws IOException {

        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        String message = "";
        if(condition == null)
            message +="condition is null" + "\n";
        if(ifTrue  == null)
            message +="ifTrue func is null" + "\n";
        if(ifFalse  == null)
            message +="ifFalse func is null" + "\n";
        if(message.length() > 0)
            throw new NullPointerException(message);
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x); // your implementation here
    }
}
