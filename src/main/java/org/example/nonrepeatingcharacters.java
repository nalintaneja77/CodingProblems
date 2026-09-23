package org.example;

import java.util.List;
import java.util.function.IntPredicate;

public class nonrepeatingcharacters {
    public static void main(String[] args) {
        String input = "swiss";

        List<Character> nonrepeatingcharacter = input.chars()
                .mapToObj(c->(char)c).filter(c->input.chars().filter(value -> c == value).count() ==1)
                .toList();

        System.out.println(nonrepeatingcharacter);
    }
}
