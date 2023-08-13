// Given an integer array nums, find the 
// subarray
//  with the largest sum, and return its sum.

 

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.
// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 



import java.util.*;
public class MaxSubArray{
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array is empty or null.");
        }

        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums [] = new int [n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        int result = maxSubArray(nums);
        System.out.println(result);
    }
}
