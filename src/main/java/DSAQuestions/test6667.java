package DSAQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class test6667 {
    static void main() {

        List<Integer> integerList  = Arrays.asList(10,20,30,40,40,50);


        System.out.println(integerList.stream().sorted(Comparator.reverseOrder()).limit(2).skip(1).toList());

    }
}
