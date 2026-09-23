package org.example;

import java.util.function.Function;
import java.util.stream.Collectors;

public class nonrepeatingcharacter {
    public static void main(String[] args) {

        String s = "racecar";

        System.out.println(s.chars().mapToObj(v->(char)v).toList().stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(b->b.getValue()==1).toList());
    }
}
