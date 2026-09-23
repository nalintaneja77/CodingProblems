package org.example;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class mostfrequentcorrectinstring {

    public static void main(String[] args) {

        String input = "success";

        Map<Character,Long> frequency =  input.chars().mapToObj(c->(char)c).filter(t->t!=' ')
                .collect(Collectors.groupingBy(c->c,Collectors.counting()));

        Character c =frequency.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();
        System.out.println(c);

    }
}
