package DSAQuestions;

import java.util.*;

public class FourSumLeetCodeMedium {

    public List<List<Integer>> fourSum(int[] nums,int target)
    {
        Set<ArrayList<Integer>> integerSet = new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            Set<Integer> integersllSet = new HashSet<>();
            for(int j = i+1;j<nums.length;j++)
            {
                for(int k = j+1;k<nums.length;k++)
                {
                    int sum = nums[i]+nums[j]+nums[k];
                    int last = target-sum;
                    if(integersllSet.contains(last))
                    {
                        ArrayList<Integer> curr = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],last));
                        Collections.sort(curr);
                        integerSet.add(curr);
                    }
                    integersllSet.add(nums[k]);
                }
            }
        }

        return new ArrayList<>(integerSet);
    }

    public static void main(String[] args) {
        FourSumLeetCodeMedium fourSumLeetCodeMedium = new FourSumLeetCodeMedium();
//        int[] nums = {10, 2, 3, 4, 5, 7, 8};
//        int target = 23;

        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        fourSumLeetCodeMedium.fourSum(nums,target);
    }
}
