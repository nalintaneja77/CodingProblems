package DSAQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class oraclemergesortedarray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

//        for(int i = nums2.length-1;i>=0;i--)
//        {
//            if(nums1[nums1.length-m]>nums2[i]) {
//                int last = nums1[nums1.length - 1];
//                int j = nums1.length - 2;
//
//
//                while (j >= 0 && nums1[j]>nums2[i])
//                {
//                    nums1[j+1] = nums1[j];
//                    j--;
//                }
//
//                nums1[j+1] = nums2[i];
//                nums2[i] = last;
//            }
//
//
//        }

        int i = m-1;//3-1 = 2;
        int j = n-1; // 3-1 = 2;
        int k = m+n-1; // 3+3-1=5;

        while(i>=0 && j>=0)
        {
            if(nums1[i]>nums2[j])
            {
            nums1[k] = nums1[i];
            i--;
            }
            else
            {
                nums1[k] =nums2[j];
                j--;
            }
            k--;
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }

        System.out.println(Arrays.toString(nums1));

    }

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m=3;
        int n=3;

//        int[]  nums1 = {1,5,9,10,15,20};
//        int[] nums2 = {2,3,8,13};
//        int[] nums1 = {0};
//        int[] nums2 = {1};
//        int m = 0;
//        int n = 1;

        oraclemergesortedarray oraclemergesortedarray =new oraclemergesortedarray();
        oraclemergesortedarray.merge(nums1,m,nums2,n);

    }
}
