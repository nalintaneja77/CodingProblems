package DSAQuestions;

public class JPMorganTest {

    public static int minSwaps(String s)
    {
        int balance = 0;
        int minbalance = 0;

        for(char c : s.toCharArray())
        {
            if(c == ')')
            {
                balance =  balance +1;
            }
            else if(balance>0)
            {
                balance =  balance -1;
            }
            else
            {
                minbalance = minbalance +1;
            }

        }

        return (minbalance+1)/2;
    }

    public static void main(String[] args) {
        JPMorganTest.minSwaps("())(");

    }
}
