package DSAQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumLeetCodeMediumUsingTwoPointer {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> integerList = new ArrayList<>();

        Arrays.sort(nums);
        for(int i =0;i<nums.length;i++)
        {
            if(i>0 && nums[i] ==nums[i-1])
            {
                continue;
            }
            for(int j = i+1;j<nums.length;j++)
            {
                if(j>i+1 && nums[j] == nums[j-1])
                {
                    continue;
                }

                int k = j+1;
                int l = nums.length-1;

                while(k<l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        ArrayList<Integer> curr = new ArrayList<>();
                        curr.add(nums[i]);
                        curr.add(nums[j]);
                        curr.add(nums[k]);
                        curr.add(nums[l]);
                        integerList.add(curr);

                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l - 1]) {
                            l--;
                        }
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }



        return integerList;

    }

    public static void main(String[] args) {
        FourSumLeetCodeMediumUsingTwoPointer fourSumLeetCodeMedium = new FourSumLeetCodeMediumUsingTwoPointer();
//        int[] nums = {10, 2, 3, 4, 5, 7, 8};
//        int target = 23;

        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        fourSumLeetCodeMedium.fourSum(nums,target);
    }
}
