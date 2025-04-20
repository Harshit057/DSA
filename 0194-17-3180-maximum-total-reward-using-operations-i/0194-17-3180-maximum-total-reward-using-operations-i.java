import java.util.*;

public class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);  // sort to handle duplicates nicely
        boolean[] dp = new boolean[4001];  // max possible sum is 2000 * 2
        dp[0] = true;

        for (int reward : rewardValues) {
            // We go in reverse to avoid overwriting results of this round
            for (int i = 4000 - reward; i >= 0; i--) {
                if (dp[i] && reward > i) {
                    dp[i + reward] = true;
                }
            }
        }

        // Find the maximum total reward
        for (int i = 4000; i >= 0; i--) {
            if (dp[i]) return i;
        }
        return 0;
    }
}
