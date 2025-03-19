public class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flips = 0, flipCount = 0;
        int[] isFlipped = new int[n]; // Tracks flips at each index

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flipCount ^= isFlipped[i - k]; // Remove effect of flips leaving the window
            }

            if (flipCount % 2 == nums[i]) { // If we need a flip at this position
                if (i + k > n) return -1; // Not enough space to flip
                flips++;
                flipCount ^= 1; // Toggle flip state
                isFlipped[i] = 1; // Mark flip at index i
            }
        }

        return flips;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] nums1 = {0,1,0};
        System.out.println(sol.minKBitFlips(nums1, 1)); // Output: 2

        int[] nums2 = {1,1,0};
        System.out.println(sol.minKBitFlips(nums2, 2)); // Output: -1

        int[] nums3 = {0,0,0,1,0,1,1,0};
        System.out.println(sol.minKBitFlips(nums3, 3)); // Output: 3
    }
}
