package com.example.task01;

import javax.crypto.NullCipher;
import java.io.IOException;
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


    }

    /*
    Дан предикат condition и две функции ifTrue и ifFalse.
    метод ternaryOperator возвращает значение функции ifTrue, если предикат выполнен, иначе ifFalse.
    Результирующая функция будет для нулевых ссылок на String возвращать 0,
    а для ненулевых ссылок возвращать длину строки.
     */
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        if(condition == null || ifFalse == null || ifTrue == null) throw new NullPointerException();

        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);

    }
}
