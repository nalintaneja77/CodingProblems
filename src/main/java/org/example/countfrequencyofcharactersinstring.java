package org.example;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class countfrequencyofcharactersinstring {

    public static void main(String[] args) {
        String input = "i am nalin";

        Map<Character,Long> frequency =  input.chars().mapToObj(c->(char)c).filter(t->t!=' ')
                .collect(Collectors.groupingBy(c->c,Collectors.counting()));

        System.out.println(frequency);
    }
}
