package org.example;

import java.util.ArrayList;
import java.util.List;

public class hexwarreclass {

    public static void main(String[] args) {
        //list of strings with fruits 5,6
        //2nd last element of the list

        List<String> fruitlist =  new ArrayList<>();
        fruitlist.add("apple");
        fruitlist.add("orange");
        fruitlist.add("banana");
        fruitlist.add("mango");
        fruitlist.add("pear");
        fruitlist.add("JJJ");
        System.out.println(fruitlist);
        System.out.println(fruitlist.stream().skip(fruitlist.size()-2).findFirst().get());


    }
}
