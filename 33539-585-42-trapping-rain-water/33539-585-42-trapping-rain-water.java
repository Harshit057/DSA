public class Solution {  // Class renamed to Solution
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();  // Use Solution class
        
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(sol.trap(height1)); // Output: 6

        int[] height2 = {4,2,0,3,2,5};
        System.out.println(sol.trap(height2)); // Output: 9
    }
}
