class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 1, right = (int)1e9;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canRob(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canRob(int[] nums, int k, int maxCap) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= maxCap) {
                count++;
                i++; // Skip adjacent house
            }
            if (count >= k) return true;
        }
        return false;
    }
}