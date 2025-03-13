class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2]; // Difference array

        // Process each pair (nums[i], nums[n-1-i])
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i], b = nums[n - 1 - i];

            int minSum = a + b;
            int maxSum = a + b;
            int minPossible = Math.min(a, b) + 1;
            int maxPossible = Math.max(a, b) + limit;

            // We need 2 moves for sums outside the range [minPossible, maxPossible]
            diff[2] += 2;  // Default 2 moves for all sums
            diff[minPossible]--;  // From here, we may need at most 1 move
            diff[maxPossible + 1]++;  // After this, we need 2 moves again

            // The sum exactly `a + b` needs 0 moves
            diff[minSum]--;  
            diff[maxSum + 1]++;  
        }

        // Compute the minimum moves using prefix sum
        int minMoves = Integer.MAX_VALUE;
        int currentMoves = 0;
        for (int sum = 2; sum <= 2 * limit; sum++) {
            currentMoves += diff[sum];
            minMoves = Math.min(minMoves, currentMoves);
        }

        return minMoves;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 4, 3};
        System.out.println(sol.minMoves(nums1, 4)); // Expected Output: 1

        int[] nums2 = {1, 2, 2, 1};
        System.out.println(sol.minMoves(nums2, 2)); // Expected Output: 2

        int[] nums3 = {1, 2, 1, 2};
        System.out.println(sol.minMoves(nums3, 2)); // Expected Output: 0
    }
}
