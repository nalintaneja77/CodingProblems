package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class countcharactersinstring {

    public static void main(String[] args) {

        String s = "i am nalin";

        Map<Character,Long> collect = s.chars().mapToObj(c->(char)c).filter(t->t!=' ')
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));



        System.out.println(collect);
    }
}
