import java.util.*;

public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums); // Step 1: Sort the array
        int median = nums[nums.length / 2]; // Step 2: Find the median
        int moves = 0;

        // Step 3: Calculate total moves needed
        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return moves;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1 = {1, 2, 3};
        System.out.println(solver.minMoves2(nums1)); // Output: 2

        int[] nums2 = {1, 10, 2, 9};
        System.out.println(solver.minMoves2(nums2)); // Output: 16
    }
}
