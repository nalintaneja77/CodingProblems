package DSAQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class sortelementsbasedonfrequency {

    public static void main(String[] args) {

        int[] arr = {2,5,6,6,6,2};
        //output : {8,8,8,2,2,5,5,6}



       LinkedHashMap<Integer,Long> valumap =
               Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet().stream().sorted(Map.Entry.<Integer,Long>comparingByValue().reversed())
                        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1, LinkedHashMap::new));


        System.out.println(valumap);
        List<Integer> sortedintegerlist = new ArrayList<>();
        for(Map.Entry<Integer,Long> s : valumap.entrySet())
        {
            int key = s.getKey();
            long frequency = s.getValue();

            for(int i = 0;i<frequency;i++)
            {
                sortedintegerlist.add(key);
            }
        }

        System.out.println(sortedintegerlist);

       // System.out.println(frequencyofnumbers);


    }
}
