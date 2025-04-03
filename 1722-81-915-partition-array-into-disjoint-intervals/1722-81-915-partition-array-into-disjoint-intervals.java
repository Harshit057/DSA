class Solution {
    public int partitionDisjoint(int[] nums) {
        int partitionIndex = 0;
        int maxLeft = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < maxLeft) {
                partitionIndex = i;
                maxLeft = currentMax; // Update maxLeft to the highest seen so far
            } else {
                currentMax = Math.max(currentMax, nums[i]);
            }
        }
        return partitionIndex + 1; // Length of left partition
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums1 = {5, 0, 3, 8, 6};
        System.out.println(obj.partitionDisjoint(nums1)); // Output: 3

        int[] nums2 = {1, 1, 1, 0, 6, 12};
        System.out.println(obj.partitionDisjoint(nums2)); // Output: 4
    }
}
