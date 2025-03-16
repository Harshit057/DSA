import java.util.*;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, h, mid)) {
                right = mid; // Try a smaller speed
            } else {
                left = mid + 1; // Increase speed
            }
        }
        return left;
    }

    private boolean canEatAll(int[] piles, int h, int k) {
        int totalHours = 0;
        for (int bananas : piles) {
            totalHours += (bananas + k - 1) / k; // Equivalent to ceil(bananas / k)
            if (totalHours > h) return false; // Early exit
        }
        return totalHours <= h;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minEatingSpeed(new int[]{3, 6, 7, 11}, 8)); // Output: 4
        System.out.println(sol.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5)); // Output: 30
        System.out.println(sol.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6)); // Output: 23
    }
}
