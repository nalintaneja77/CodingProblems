package DSAQuestions;

public class numberishavingpoweroftwo {

    public int numberevenorodd(int n)
    {
        if((n & 1) == 0)
            System.out.println("Even");
        else
            System.out.println("Odd");

        return 0;
    }
    public static void main(String[] args) {
        numberishavingpoweroftwo bb =  new numberishavingpoweroftwo();
        bb.numberevenorodd(4);
    }
}
