import java.util.*;

public class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        
        // Create an array of indices and sort it by decreasing growTime
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        
        Arrays.sort(idx, (a, b) -> growTime[b] - growTime[a]);

        int currentDay = 0; // cumulative planting days
        int maxBloom = 0;   // latest bloom time

        for (int i = 0; i < n; i++) {
            int seed = idx[i];
            currentDay += plantTime[seed]; // plant this seed
            maxBloom = Math.max(maxBloom, currentDay + growTime[seed]); // when it will bloom
        }

        return maxBloom;
    }
}
