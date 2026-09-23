package DSAQuestions;

import java.util.Arrays;

public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs)
    {
        Arrays.sort(strs);
        String firstValue = strs[0];
        String lastValue = strs[strs.length-1];
        int minLength = Math.min(firstValue.length(),lastValue.length());

        int i = 0;
        while(i<minLength && firstValue.charAt(i) == lastValue.charAt(i))
        {
            i++;
        }
        return firstValue.substring(0,i);
    }

    public static void main(String[] args) {

        String[] strsvalue = {"flower","flow","floght","fligm"};
        //String[] strsvalue = {"dog","racecar","car"};
        longestCommonPrefix longestCommonPrefix =new longestCommonPrefix();
        longestCommonPrefix.longestCommonPrefix(strsvalue);
    }
}
