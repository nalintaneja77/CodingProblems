package org.example;

import java.util.*;

public class duplicationnumbers {

    public static void main(String[] args) {

        int[] arr = {1,2,3,2,5,1,6};

        Set<Integer> valueList = new HashSet<>();

        for(int i : arr)
        {
            valueList.add(i);
        }
//
//        System.out.println(valueList);
//        List<Integer> bb =new ArrayList<>();
//        for(int i = 0;i<valueList.size();i++)
//        {
//            if(!bb.contains(valueList.get(i)))
//            {
//                bb.add(valueList.get(i));
//            }
//        }

        System.out.println(valueList);

    }
}
