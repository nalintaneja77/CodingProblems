package org.example;

import java.util.Arrays;
import java.util.List;

public class flattenlist {
    public static void main(String[] args) {

        List<List<Integer>> listofLists = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5),Arrays.asList(6,7,8,9));

        List<Integer> flattenedList = listofLists.stream().flatMap(List::stream ).toList();
        System.out.println(flattenedList);

    }
}
