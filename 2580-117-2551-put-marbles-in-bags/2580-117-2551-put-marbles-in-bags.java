import java.util.*;

public class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        List<Integer> pairSums = new ArrayList<>();

        // Step 1: Calculate pair sums of adjacent marbles
        for (int i = 0; i < n - 1; i++) {
            pairSums.add(weights[i] + weights[i + 1]);
        }

        // Step 2: Sort the pairSums
        Collections.sort(pairSums);

        // Step 3: Pick k-1 smallest for min score, k-1 largest for max score
        long minScore = 0, maxScore = 0;
        for (int i = 0; i < k - 1; i++) {
            minScore += pairSums.get(i);
            maxScore += pairSums.get(pairSums.size() - 1 - i);
        }

        return maxScore - minScore;
    }
}
