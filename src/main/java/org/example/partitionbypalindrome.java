package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class partitionbypalindrome {
    public static void main(String[] args) {

        List<String> wordsss = Arrays.asList("radar","level","java","stream");
        Map<Boolean,List<String>> partitioned = wordsss.stream().collect(Collectors.partitioningBy(s -> {
            StringBuilder ss = new StringBuilder(s);
            return s.contentEquals(ss.reverse());
        }));

        System.out.println(partitioned);
    }
}
