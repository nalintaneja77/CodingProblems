package DSAQuestions;


import java.util.function.Function;
import java.util.stream.Collectors;

//WAP first non repeating character in java 8
public class test777 {
    static void main() {

        String s = "SWASWA";

        System.out.println(s.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting())).entrySet().stream()
                .filter(b->b.getValue()==1).findFirst().get().getKey());

    }
}
