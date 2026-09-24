package dsamore;

/*
Sliding Window: instead of recomputing a result for every possible
sub-array/sub-string from scratch (brute force, O(n*k) or worse), keep a
window of elements and slide it across the array one step at a time,
adding the new element and removing the old one. This turns the brute
force approach into O(n).

Two flavors are shown here:
1) Fixed-size window  -> maxSumFixedWindow: window size k never changes.
2) Variable-size window -> longestUniqueSubstring: window grows while a
   condition holds, and shrinks from the left when it's violated.
*/
public class SlidingWindow {

    // max sum of any contiguous sub-array of size k
    public static int maxSumFixedWindow(int[] nums, int k) {

        int windowSum = 0;

        // build the first window
        for (int i = 0; i < k; i++) {
            windowSum = windowSum + nums[i];
        }

        int maxSum = windowSum;

        // slide the window: drop nums[i-k] on the left, add nums[i] on the right
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    // length of the longest substring with no repeating characters
    public static int longestUniqueSubstring(String s) {

        boolean[] seen = new boolean[128];
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // shrink from the left until the duplicate drops out of the window
            while (seen[c]) {
                seen[s.charAt(left)] = false;
                left++;
            }

            seen[c] = true;
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    static void main() {

//        int[] nums = {2, 1, 5, 1, 3, 2};
//        int k = 3;
//        System.out.println("Max sum of window size " + k + ": " + maxSumFixedWindow(nums, k)); // expected 9 (5+1+3)

        String s = "abcabcbb";
        System.out.println("Longest unique substring length: " + longestUniqueSubstring(s)); // expected 3 (abc)
    }
}
