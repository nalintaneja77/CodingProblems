package org.example;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class removeduplicatecharacters {

    public static void main(String[] args) {
        String c = "HaPpyNewYear";
        StringBuilder ff =  new StringBuilder();

    Map<Character,Long> mm =
            c.chars().mapToObj(a->(char)a).collect(Collectors.groupingBy(z->z,LinkedHashMap::new,Collectors.counting()));

        System.out.println(mm);

    mm.entrySet().stream().filter(z->z.getValue()==1).forEach(d-> ff.append(d.getKey()));

        System.out.println(ff);

        System.out.println(c.chars().mapToObj(a->(char)a).distinct().map(String::valueOf).collect(Collectors.joining()));







    }
}
