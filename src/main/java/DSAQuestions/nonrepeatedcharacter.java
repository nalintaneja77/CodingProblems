package DSAQuestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class nonrepeatedcharacter {

    public static void main(String[] args) {

        String s = "swiss";

        //first non repeating character
        System.out.println(s.chars().mapToObj(x->(char)x)
                .collect(Collectors.groupingBy(b->b,Collectors.counting())).entrySet().stream()
                .filter(n->n.getValue()==1).findFirst().get().getKey());

        //second non repeating character
        System.out.println(s.chars().mapToObj(x->(char)x)
                        .collect(Collectors.groupingBy(b->b,Collectors.counting())).entrySet().stream()
                        .filter(n->n.getValue()==1).skip(1).findFirst().get().getKey());

        //first repeating character
        System.out.println(s.chars().mapToObj(x->(char)x)
                .collect(Collectors.groupingBy(b->b,Collectors.counting())).entrySet().stream()
                .filter(n->n.getValue()>1).findFirst().get().getKey());




        String b = "aabbc";

        Map<Character,Integer> nonrepeatedchracter = new LinkedHashMap<>();

        for(int i = 0;i<b.length();i++)
        {
            if(!nonrepeatedchracter.containsKey(b.charAt(i)))
            {
                nonrepeatedchracter.put(b.charAt(i),1);

            }
            else
            {
                nonrepeatedchracter.put(b.charAt(i),nonrepeatedchracter.get(b.charAt(i))+1);
            }

        }



        System.out.println(nonrepeatedchracter.entrySet().stream()
                .filter(x->x.getValue()==1).findFirst().get().getKey());


        String bxt = "\n \thello \t \n";
        String bxt1 = "\u2002 hello \u2002";

        //output: hello

        System.out.println(bxt1.strip());


        //reverse words in a sentence

        String vv = "I love India"; //without using the split function

        StringBuilder vvx = new StringBuilder();
        char[] x = vv.toCharArray();

        System.out.println(Arrays.toString(x));
        List<String> ccv = new ArrayList<>();
        for(int i = x.length-1;i>=0;i--)
        {
            if(x[i]==' ')
            {
                ccv.add(vvx.reverse().toString());
                vvx.setLength(0);
            }
            else
            {
                vvx.append(x[i]);
            }
        }
        ccv.add(vvx.reverse().toString());
        for(String k : ccv)
        {
            System.out.print(k+ " ");
        }
        System.out.println();
        //reverse using streams
        System.out.println(Arrays.stream(vv.split(" ")).collect(Collectors.collectingAndThen(Collectors.toList(),list-> {
                    Collections.reverse(list);
                    return String.join(" ", list);
                }
        )).toString());

        String s1 = "abcd";
        String s2 = "cdab";

        boolean result  = s1.length() == s2.length() && (s1+s2).contains(s1);
        System.out.println(result);

        List<Integer> cc = Arrays.asList(10,30,50,90,20,60);
        System.out.println(cc.stream().min(Comparator.comparing(Integer::valueOf)).get());

    }
}
