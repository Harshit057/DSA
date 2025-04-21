import java.util.*;

public class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0])); // sort by start day

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap for end days
        int i = 0, n = events.length, day = 0, count = 0;

        // Find the last day we might need to consider
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        for (day = 1; day <= maxDay; day++) {
            // Add all events starting today
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            // Remove expired events
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            // Attend the event that ends the earliest
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
        }

        return count;
    }
}
