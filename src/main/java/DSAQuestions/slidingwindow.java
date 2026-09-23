package DSAQuestions;

import java.util.Map;

public class slidingwindow {

    public static void main(String[] args) {

       // int[] arr = {5,2,-1,0,3};
        int[] arr = {2,3,-8,7,-1,2,3};
        int k = 4;
        int max_value = Integer.MIN_VALUE;

        for(int i =0;i<arr.length-k+1;i++)
        {
           int sum =0;
            for(int j = 0;j<k;j++)
            {
                sum =sum + arr[i+j];
            }

            max_value = Math.max(sum,max_value);
        }

        System.out.println(max_value);
    }
}
