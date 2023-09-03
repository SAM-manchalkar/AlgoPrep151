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



class NextGreater3 {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int index1 = digits.length - 2;
        while (index1 >= 0 && digits[index1] >= digits[index1 + 1]) {
            index1--;
        }
        if (index1 == -1) {
            return -1;
        }
        int index2 = digits.length - 1;
        while (digits[index2] <= digits[index1]) {
            index2--;
        }
        char temp = digits[index1];
        digits[index1] = digits[index2];
        digits[index2] = temp;
        reverse(digits, index1 + 1, digits.length - 1);
        long result = Long.parseLong(new String(digits));
        if (result > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) result;
    }
    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
