package com.example.task01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task01Main {
    public static void main(String[] args) throws IOException {

        // TODO С корректно реализованным методом ternaryOperator должен компилироваться и успешно работать следующий код:


        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        String s = "hi";
        Integer apply = safeStringLength.apply(s);
    }

    public static <T, U> Function<T, U> ternaryOperator(
        Predicate<? super T> condition,
        Function<? super T, ? extends U> ifTrue,
        Function<? super T, ? extends U> ifFalse) {


        if (condition == null || ifTrue == null || ifFalse == null) {
            throw new NullPointerException("One of arguments is null");
        }
       

        Function<T, U> function = (obj) -> condition.test(obj) ? ifTrue.apply(obj) : ifFalse.apply(obj);

        return function;
    }
}
