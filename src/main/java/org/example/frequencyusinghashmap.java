package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class frequencyusinghashmap {

    public static void main(String[] args) {

        String input = "I love love love India India";

        String[] values = input.split(" ");

        List<String> valueslist =  new ArrayList<>();

        for(String s :  values)
        {
            valueslist.add(s);
        }

           Map<String,Integer> wordlistfrequency = new HashMap<>();


        Map<String,Long> wordlistfrequencyvv = valueslist.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(wordlistfrequencyvv.entrySet().stream().filter(stringLongEntry -> stringLongEntry.getValue() > 1).toList());

        int count = 1;

        for(int i = 0;i<valueslist.size();i++)
        {
            if(valueslist.get(i).equals("love")) {
                if (!wordlistfrequency.containsKey("love")) {
                    wordlistfrequency.put("love", count);
                } else {
                    wordlistfrequency.put("love", count = count + 1);
                }
            }
            else if(valueslist.get(i).equals("India"))
            {
                count = 1;
                if (!wordlistfrequency.containsKey("India")) {
                    wordlistfrequency.put("India", count);
                } else {
                    wordlistfrequency.put("India", count = count + 1);
                }
            }
        }

        System.out.println(wordlistfrequency);
            }
}
