package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bubblesortinlist {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 2, 5, 6);

        int[] arr = new int[integerList.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = integerList.get(i);
        }

        for(int i = 0;i<arr.length-1;i++)
        {
            for(int j = 0;j<arr.length-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i = 0;i<arr.length;i++)
        {
            System.out.print(arr[i]);
        }
    }

}
