package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class preserveinsertionandremoveduplicate {

    public static void main(String[] args) {

        int[] arr = {1,2,3,2,5,1,6};

        Set<Integer> integerSet = new HashSet<>();
        for(int i : arr)
        {
            integerSet.add(i);
        }

        System.out.println(integerSet);
    }
}
