import java.util.*;

public class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        List<List<int[]>> endAt = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            endAt.add(new ArrayList<>());
        }

        for (int[] ride : rides) {
            int start = ride[0], end = ride[1], tip = ride[2];
            endAt.get(end).add(new int[]{start, end - start + tip});
        }

        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            // Option 1: skip this point
            dp[i] = dp[i - 1];

            // Option 2: take rides ending here
            for (int[] ride : endAt.get(i)) {
                int start = ride[0];
                int earn = ride[1];
                dp[i] = Math.max(dp[i], dp[start] + earn);
            }
        }

        return dp[n];
    }
}
