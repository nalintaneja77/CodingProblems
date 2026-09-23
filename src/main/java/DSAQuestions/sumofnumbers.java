package DSAQuestions;

public class sumofnumbers {

    public static Integer findProduct(int a,int b)
    {
        int sum = 0;
        for(int i =0;i<b;i++)
        {
            sum = sum+a;
        }

        return sum;
    }
    public static void main(String[] args) {

        System.out.println(sumofnumbers.findProduct(2,5));
    }
}
