// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

// Example 1:

// Input: nums = [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
// Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].
// Example 2:

// Input: nums = [-7,-3,2,3,11]
// Output: [4,9,9,49,121]
 

import java.util.*;
public class rotatearray {
    public static void rotate(int[] nums, int k) {
        for(int i=0; i<k; i++){
            for(int j=nums.length; j==0; j--){
                System.out.print(nums[j]);
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int d = sc.nextInt();
        int [] arr = new int[a];
        for(int p=0; p<a; p++){
            arr[p] = sc.nextInt();
        }
        rotate(arr,d);
    }
}
