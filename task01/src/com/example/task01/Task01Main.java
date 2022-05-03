package com.example.task01;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task01Main {
    public static void main(String[] args) throws IOException {
        Predicate<Object> condition = Objects::isNull; // Возращает bool         // это хранться в t
        Function<Object, Integer> ifTrue = obj -> 0; // Преобразует обект в int  // это хранться в t
        Function<CharSequence, Integer> ifFalse = CharSequence::length; // преобразует последовательность символов в int // это хранться в t
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue,  ifFalse);
        // CharSequence реализует класс String поэтому возможно сочитание obj,CharSequence,String
    }

        public static<T, U> Function<T, U> ternaryOperator( // первыми определяем дженерики для статических методов, после показывет что возращаем
                Predicate<? super T> condition,              //  T - это obj, U - это int
                Function<? super T, ? extends U> ifTrue,
                Function<? super T, ? extends U> ifFalse) {  //? super t - показывает что мы примем лишь тип t и его родителей U отправим его или родителей

            if (condition == null || ifTrue == null || ifFalse == null) {
                throw new NullPointerException();
            }

            return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t); // абстрактный метод запуска // собраем из предеката и функций ещё одну функцию
        }
}
