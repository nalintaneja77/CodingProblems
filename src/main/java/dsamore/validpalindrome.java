package dsamore;

public class validpalindrome {

    public static boolean isPalindrome(String s)
    {
            String lowercasestring = s.toLowerCase();
            StringBuilder gg = new StringBuilder();
            char[] stingray = lowercasestring.toCharArray();

        for (char c : stingray) {
            if(Character.isLetter(c) || Character.isDigit(c))
            {
                gg.append(c);
            }
        }


        StringBuilder b2 = new StringBuilder();
        char[] reversedString = gg.toString().toCharArray();

        for(int i = reversedString.length-1;i>=0;i--)
        {
            b2.append(reversedString[i]);
        }

       return b2.compareTo(gg) == 0;

    }


    static void main() {

        //String s = "A man, a plan, a canal: Panama";
        //  String s = " ";
          String s = "0P";

        System.out.println(validpalindrome.isPalindrome(s));


    }
}
