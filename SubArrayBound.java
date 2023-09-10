// Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays such that the value 
//of the maximum array element in that subarray is in the range [left, right].

// The test cases are generated so that the answer will fit in a 32-bit integer.

 

class SubArrayBound {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
         int count = 0;
    int leftBound = -1;  // Initialize the left boundary of the subarray
    int rightBound = -1; // Initialize the right boundary of the subarray
    
    for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        
        if (num < left) {
            // Extend the current subarray to include the current element
            count += (rightBound - leftBound);
        } else if (num > right) {
            // Reset the boundaries as we cannot include this element
            leftBound = i;
            rightBound = i;
        } else {
            // Update the right boundary of the subarray
            rightBound = i;
            // Extend the current subarray to include the current element
            count += (rightBound - leftBound);
        }
    }
    
    return count;
    }
}
