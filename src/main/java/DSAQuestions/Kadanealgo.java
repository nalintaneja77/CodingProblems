package DSAQuestions;

public class Kadanealgo {

    public static void main(String[] args) {

        int[] arr ={2,3,-8,7,-1,2,3};
        int res = arr[0];

        for(int i = 0;i<arr.length;i++)
        {
            int sum =0;
            for(int j = i ;j<arr.length;j++)
            {
                sum = sum+arr[j];

            }

            res = Math.max(sum,res);
        }

        System.out.println(res);
    }
}
