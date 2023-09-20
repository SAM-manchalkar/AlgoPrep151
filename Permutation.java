// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums, used, current, result);
        return result;
    }

    private void permuteHelper(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Add a copy of the current permutation to the result
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                current.add(nums[i]);
                used[i] = true;

                permuteHelper(nums, used, current, result);

                used[i] = false;
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);

        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }
}
