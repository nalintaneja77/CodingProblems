package DSAQuestions;

public class backtrackingproblem {

    static void generate(String current,int n)
    {

        if(current.length()==n)
        {
            System.out.println(current);
            return;
        }


        generate(current + "0",n);
        generate(current + "1",n);

    }

    public static void main(String[] args) {

        backtrackingproblem.generate("",3);
    }
}
