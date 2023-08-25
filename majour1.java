// Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

// Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

 

// Example 1:

// Input: n = 12
// Output: 21
// Example 2:

// Input: n = 21
// Output: -1
 

// Constraints:

// 1 <= n <= 231 - 1


class majour1 {
    public int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        
        if (i == -1) {
            return -1; // No valid answer exists
        }
        
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }
        
        // Swap digits[i] and digits[j]
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
        
        // Reverse the subarray from i + 1 to the end
        reverse(digits, i + 1, digits.length - 1);
        
        long result = Long.parseLong(new String(digits));
        return (result > Integer.MAX_VALUE) ? -1 : (int) result;
    }
    
    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 12345; // Replace with your input integer
        int result = solution.nextGreaterElement(n);
        System.out.println("Next greater integer: " + result);
    }
}
