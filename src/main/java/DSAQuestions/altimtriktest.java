package DSAQuestions;

import java.util.Arrays;

public class altimtriktest {


    //nums =[1,2,3,4]
    //output = [24,12,8,6]
    static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int[] output = new int[nums.length];


        for (int i = 0 ; i < nums.length; i++) {

            int product =1;

            for(int j = 0;j< nums.length;j++)
            {
                if(i!=j) {
                    product = product * nums[j];
                }
            }

            output[i] = product;
        }

        System.out.println(Arrays.toString(output));

    }
}

