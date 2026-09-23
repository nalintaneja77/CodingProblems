package DSAQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test444 {
    static void main() {

        List<String> stringList = Arrays.asList("10", "abc", "20", "xyz", "5");
        List<Integer> integers =  new ArrayList();


        for(String s:stringList)
        {
            try
            {
                integers.add(Integer.parseInt(s));
            }
            catch (NumberFormatException e)
            {
                System.out.println("");
            }
        }

        System.out.println(integers.stream().mapToInt(s->s).sum());
    }
}
