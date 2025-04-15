public class Solution {
    public int lengthOfLIS(int[] nums) {
        // tails[i] holds the minimum tail value for an increasing subsequence of length i+1
        int[] tails = new int[nums.length];
        int size = 0; // Represents the length of the longest found subsequence
        
        for (int num : nums) {
            int left = 0, right = size;
            // Binary search for the insertion point for num in the tails array
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // Update tails at the insertion point
            tails[left] = num;
            // If num extends the largest subsequence, increase the size.
            if (left == size) {
                size++;
            }
        }
        
        return size;
    }
}
