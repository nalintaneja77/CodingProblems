package org.example;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Biconsumer {
    public static void main(String[] args) {
        BiConsumer<String, Integer> print =
                (name, amount) ->
                        System.out.println(name + " : " + amount);

        print.accept("Nalin",10000);

        BiFunction<Integer, Integer, Integer> add =
                (a, b) -> a + b;

        System.out.println(add.apply(10, 20));
    }
}
