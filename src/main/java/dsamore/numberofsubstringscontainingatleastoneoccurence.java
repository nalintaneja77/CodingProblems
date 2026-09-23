package dsamore;

public class numberofsubstringscontainingatleastoneoccurence {

    public static int numberOfSubstrings(String s)
    {
        // last index where 'a', 'b', 'c' were seen
        int[] lastSeen = {-1, -1, -1};
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            lastSeen[s.charAt(i) - 'a'] = i;

            // every start index from 0 up to the smallest last-seen index
            // gives a substring ending at i that contains all three chars
            int minLast = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            count  = count + minLast + 1;
        }

        return count;
    }

    static void main() {

       // String s = "abcabc";      // expected 10
        //String s = "aaacb";     // expected 3
        String s = "abc";       // expected 1
        System.out.println(numberofsubstringscontainingatleastoneoccurence.numberOfSubstrings(s));

    }
}
