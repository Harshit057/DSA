import java.util.*;

public class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int totalRabbits = 0;

        for (int answer : answers) {
            if (!map.containsKey(answer) || map.get(answer) == 0) {
                totalRabbits += answer + 1;
                map.put(answer, answer);
            } else {
                map.put(answer, map.get(answer) - 1);
            }
        }

        return totalRabbits;
    }
}
