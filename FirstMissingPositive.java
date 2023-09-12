// Given an unsorted integer array nums, return the smallest missing positive integer.

// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

// Example 1:

// Input: nums = [1,2,0]
// Output: 3
// Explanation: The numbers in the range [1,2] are all in the array.
// Example 2:

// Input: nums = [3,4,-1,1]
// Output: 2
// Explanation: 1 is in the array but 2 is missing.
// Example 3:

// Input: nums = [7,8,9,11,12]
// Output: 1
// Explanation: The smallest positive integer 1 is missing.

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Rearrange the elements to their correct positions
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] to its correct position
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: Find the first index where nums[i] != i+1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all elements are in their correct positions, return n + 1
        return n + 1;
    }
}