package DSAQuestions;

public class reversebitsinbitmanipulation {

    static int reverseBits(int n)
    {
        int ans = 0;

        while( n > 0)
        {
           ans = ans << 1;
           if((n & 1)==1)
           {
               ans = ans | 1;

           }

           n = n>>1;

        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(reversebitsinbitmanipulation.reverseBits(13));

    }
}
