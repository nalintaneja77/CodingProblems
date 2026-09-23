package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class longeststringinlist {

    public static void main(String[] args) {


        List<String> wordsdd = Arrays.asList("Java", "Stream", "API", "Development");

        String longest = wordsdd.stream().reduce((s, s2) -> {
            if (s.length() > s2.length()) {
                return s;
            }
            else
                return s2;
        }).orElse(null);

        System.out.println(longest);
    }

}
