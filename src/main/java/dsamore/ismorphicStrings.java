package dsamore;

import java.util.HashMap;
import java.util.Map;

public class ismorphicStrings {
    public static boolean isIsomorphic(String s1, String s2) {
        Map<Character,Integer> v1 = new HashMap<>();
        Map<Character,Integer> v2 = new HashMap<>();

        for(int i = 0;i<s1.length();i++) {
            if (!v1.containsKey(s1.charAt(i))) {
                v1.put(s1.charAt(i), i);
            }

            if (!v2.containsKey(s2.charAt(i))) {
                v2.put(s2.charAt(i), i);
            }


            if (!v1.get(s1.charAt(i)).equals(v2.get(s2.charAt(i))))
            {
                return false;
            }

        }

        return true;
    }
    static void main() {

        String s1 = "f11";
        String s2 = "b23";


        System.out.println(ismorphicStrings.isIsomorphic(s1,s2));

    }
}
