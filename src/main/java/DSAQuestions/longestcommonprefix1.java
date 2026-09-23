package DSAQuestions;

public class longestcommonprefix1 {

    public static void main(String[] args) {
        String[] s = {"abc","abcd","abcde","ab","abcd","abcdef"};

        StringBuilder result = new StringBuilder();
        String firstValue = s[0];
        for(int i = 0;i<firstValue.length();i++)
        {
            char ch = firstValue.charAt(i);

            for(int j =1;j<s.length;j++)
            {
                if(i>=s[j].length() || s[j].charAt(i)!=ch)
                {
                    System.out.println(result);
                    return;
                }
            }

            result.append(ch);
        }


    }
}
