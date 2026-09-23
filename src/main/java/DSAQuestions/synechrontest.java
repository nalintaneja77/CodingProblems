package DSAQuestions;

import java.util.HashSet;
import java.util.Set;

public class synechrontest {
    static void main() {

        int[] bb ={40,40,40};

        Set<Integer> cc = new HashSet<>();
        int count =0;
        for(int c : bb)
        {
            cc.add(c);
            count = count +1;
        }

        System.out.println(count-1);
        System.out.println(cc);
    }
}
