public class Solution {
    public boolean increasingTriplet(int[] nums) {
        // Initialize the smallest and second smallest values as MAX_VALUE.
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        // Traverse through each number in the array
        for (int num : nums) {
            if (num <= first) {
                // Update first if current number is smaller than first
                first = num;
            } else if (num <= second) {
                // Update second if current number is bigger than first but smaller than second
                second = num;
            } else {
                // We have found a number larger than both first and second,
                // which means an increasing triplet exists.
                return true;
            }
        }
        // No increasing triplet was found.
        return false;
    }
}
