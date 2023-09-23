// The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

public class PermutaionSequence {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();
        
        // Initialize the list of available numbers
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        k--; // Convert k to 0-based index
        
        // Calculate factorial of (n - 1)
        int factorial = 1;
        for (int i = 2; i < n; i++) {
            factorial *= i;
        }
        
        // Generate the permutation
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial;
            result.append(numbers.get(index));
            numbers.remove(index);
            k %= factorial;
            
            // Update factorial for the next iteration
            if (i > 0) {
                factorial /= i;
            }
        }
        
        return result.toString();
    }
}
