package org.example;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class removingspecialcharacters {

    public static void main(String[] args) {
        String str = "java#java$";

        System.out.println(str.chars().mapToObj(s->(char)s).filter(Character::isLetter).collect(Collectors.groupingBy(v->v,
                Collectors.counting())));


    }
}
