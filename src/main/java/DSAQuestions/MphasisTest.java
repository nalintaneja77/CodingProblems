package DSAQuestions;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MphasisTest {

    //String
    public static void main(String[] args) {
      //  String s = "aabbccd";
        String s = "abaccada";

        Map<Character, Long> countofcharacters = s.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        s= "abc";

        System.out.println(s);
        System.out.println(countofcharacters);
    }
}
