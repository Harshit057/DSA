import java.util.*;

public class Solution {  // Renamed class to Solution
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[] count = new int[size + 1];
        int repeated = -1, missing = -1;

        // Count occurrences of each number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
            }
        }

        // Identify the repeated and missing numbers
        for (int i = 1; i <= size; i++) {
            if (count[i] == 2) {
                repeated = i;
            } else if (count[i] == 0) {
                missing = i;
            }
        }

        return new int[]{repeated, missing};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] grid1 = {{1, 3}, {2, 2}};
        System.out.println(Arrays.toString(sol.findMissingAndRepeatedValues(grid1))); // Output: [2, 4]

        int[][] grid2 = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
        System.out.println(Arrays.toString(sol.findMissingAndRepeatedValues(grid2))); // Output: [9, 5]
    }
}
