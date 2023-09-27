// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

 

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the candidates to handle duplicates efficiently
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Add a valid combination to the result
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue; // Skip duplicates to avoid duplicate combinations
            }

            int num = candidates[i];
            if (num <= target) {
                current.add(num); // Include the current candidate
                backtrack(result, current, candidates, target - num, i + 1); // Recursively search for combinations
                current.remove(current.size() - 1); // Backtrack
            } else {
                break; // Stop if the candidate is greater than the remaining target
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {10, 1, 2, 7, 6, 5};
        int target = 8;
        List<List<Integer>> result = solution.CombinationSum2(candidates, target);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}

