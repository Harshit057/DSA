public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long totalFlowers = (long) m * k;
        if (bloomDay.length < totalFlowers) return -1;

        int left = 1, right = 1_000_000_000;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                answer = mid;
                right = mid - 1; // try smaller day
            } else {
                left = mid + 1; // need more time
            }
        }

        return answer;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0, flowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0; // reset if break in adjacency
            }
        }

        return bouquets >= m;
    }
}
