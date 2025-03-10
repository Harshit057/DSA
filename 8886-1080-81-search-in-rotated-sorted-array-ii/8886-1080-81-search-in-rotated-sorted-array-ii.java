class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If found, return true
            if (nums[mid] == target) return true;

            // If we have duplicates at both ends, shrink the search space
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Search in left half
                } else {
                    left = mid + 1; // Search in right half
                }
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Search in right half
                } else {
                    right = mid - 1; // Search in left half
                }
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.search(new int[]{2,5,6,0,0,1,2}, 0)); // Output: true
        System.out.println(sol.search(new int[]{2,5,6,0,0,1,2}, 3)); // Output: false
        System.out.println(sol.search(new int[]{1,1,1,1,1,3,1}, 3)); // Output: true
    }
}
