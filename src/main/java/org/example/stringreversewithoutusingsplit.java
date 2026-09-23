package org.example;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class stringreversewithoutusingsplit {

    public static void main(String[] args) {



        String input = "I love India";

        StringBuilder stringBuilder =new StringBuilder();
        List<String> stringList = new ArrayList<>();
        for(char c : input.toCharArray())
        {
            if(c == ' ')
            {
                stringList.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
            else {
                stringBuilder.append(c);
            }

        }
        stringList.add(stringBuilder.toString());

        for(int i  = stringList.size()-1;i>=0;i--)
        {
            System.out.print(stringList.get(i)+ " ");
        }

        System.out.println();
        StringBuilder ss = new StringBuilder(input.toString());

        System.out.println(ss.reverse().toString());


    }
}
