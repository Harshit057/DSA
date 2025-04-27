public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        
        long[] prefixSums = new long[nums.length + 1];
        
        // Create prefix sums
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        
        return mergeSort(prefixSums, 0, prefixSums.length - 1, lower, upper);
    }
    
    private int mergeSort(long[] prefixSums, int left, int right, int lower, int upper) {
        if (left >= right) return 0;
        
        int mid = left + (right - left) / 2;
        int count = mergeSort(prefixSums, left, mid, lower, upper) + mergeSort(prefixSums, mid + 1, right, lower, upper);
        
        int l = mid + 1, r = mid + 1;
        
        for (int i = left; i <= mid; i++) {
            while (l <= right && prefixSums[l] - prefixSums[i] < lower) l++;
            while (r <= right && prefixSums[r] - prefixSums[i] <= upper) r++;
            count += r - l;
        }
        
        // Merge step
        merge(prefixSums, left, mid, right);
        
        return count;
    }
    
    private void merge(long[] prefixSums, int left, int mid, int right) {
        long[] temp = new long[right - left + 1];
        
        int i = left, j = mid + 1, k = 0;
        
        while (i <= mid && j <= right) {
            if (prefixSums[i] <= prefixSums[j]) {
                temp[k++] = prefixSums[i++];
            } else {
                temp[k++] = prefixSums[j++];
            }
        }
        
        while (i <= mid) {
            temp[k++] = prefixSums[i++];
        }
        
        while (j <= right) {
            temp[k++] = prefixSums[j++];
        }
        
        for (int p = 0; p < temp.length; p++) {
            prefixSums[left + p] = temp[p];
        }
    }
}
