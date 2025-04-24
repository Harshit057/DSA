import java.util.*;

public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int total = 0;
        int n = nums.length;

        // Step 1: Count number of distinct elements in entire array
        Set<Integer> uniqueElements = new HashSet<>();
        for (int num : nums) {
            uniqueElements.add(num);
        }
        int totalDistinct = uniqueElements.size();

        // Step 2: Brute-force sliding window from every i to j
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                seen.add(nums[j]);
                if (seen.size() == totalDistinct) {
                    total++;
                }
            }
        }

        return total;
    }
}
