import java.util.*;

public class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) Arrays.stream(ranks).min().getAsInt() * (long) cars * cars; // Handle large values

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepairInTime(ranks, cars, mid)) {
                right = mid;  // Try a smaller time
            } else {
                left = mid + 1;  // Increase time
            }
        }
        return left;
    }

    private boolean canRepairInTime(int[] ranks, int cars, long t) {
        long totalCars = 0;
        for (int r : ranks) {
            totalCars += (long) Math.sqrt(t / r); // Max cars this mechanic can repair
            if (totalCars >= cars) return true; // Early stopping
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.repairCars(new int[]{4, 2, 3, 1}, 10)); // Output: 16
        System.out.println(sol.repairCars(new int[]{5, 1, 8}, 6)); // Output: 16
    }
}
