class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];  // Prefix max array
        int[] rightMax = new int[n]; // Suffix max array
        
        // Compute prefix max
        leftMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }

        // Compute suffix max
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        // Compute the max triplet value
        long maxValue = 0;
        for (int j = 1; j < n - 1; j++) {
            int left = leftMax[j - 1];  // max nums[i] for i < j
            int right = rightMax[j + 1]; // max nums[k] for k > j
            if (left > nums[j]) {
                maxValue = Math.max(maxValue, (long)(left - nums[j]) * right);
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums1 = {12, 6, 1, 2, 7};
        System.out.println(obj.maximumTripletValue(nums1)); // Output: 77

        int[] nums2 = {1, 10, 3, 4, 19};
        System.out.println(obj.maximumTripletValue(nums2)); // Output: 133

        int[] nums3 = {1, 2, 3};
        System.out.println(obj.maximumTripletValue(nums3)); // Output: 0
    }
}
