class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long operations = 0;
        int prev = nums[n - 1]; // Start from the last element

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > prev) {
                // Find how many times we need to break nums[i] to fit before prev
                int parts = (nums[i] + prev - 1) / prev;
                operations += parts - 1;
                prev = nums[i] / parts; // Update prev to the largest valid number
            } else {
                prev = nums[i]; // No split needed, update prev normally
            }
        }

        return operations;
    }
}
