package DSAQuestions;

public class StringMatchingWildcards {

    static boolean match(String first,String second){

        if(first.isEmpty() && second.isEmpty())
        {
            return true;
        }

        if(first.length() > 1 && first.charAt(0) == '*')
        {
            int i = 0;

            while(i+1<first.length() && first.charAt(i+1) == '*')
            {
                i++;
            }
            first = first.substring(i);
        }

        if (first.length() > 1 && first.charAt(0) == '*' && second.isEmpty()) {
            return false;
        }

        if (!first.isEmpty() && !second.isEmpty() && (first.charAt(0) == '?' || first.charAt(0) == second.charAt(0))) {
            return match(first.substring(1), second.substring(1));
        }


        if (!first.isEmpty() && first.charAt(0) == '*') {
            return match(first.substring(1), second) || match(first, second.substring(1));
        }


        return false;


    }

    static void test(String first,String second)
    {

        if(match(first,second))
        {
            System.out.println("Yes");
        }
        else
            {
            System.out.println("No");
            }
    }

    static void main() {

        test("g*ks","geeks");

    }
}
