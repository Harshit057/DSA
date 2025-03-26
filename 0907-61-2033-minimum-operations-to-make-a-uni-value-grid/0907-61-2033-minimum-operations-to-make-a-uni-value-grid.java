import java.util.*;

public class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> values = new ArrayList<>();
        int m = grid.length, n = grid[0].length;

        // Flatten the grid and check if transformation is possible
        int base = grid[0][0];
        for (int[] row : grid) {
            for (int num : row) {
                if ((num - base) % x != 0) return -1; // Impossible case
                values.add(num);
            }
        }

        // Sort values to find median
        Collections.sort(values);
        int median = values.get(values.size() / 2);
        int operations = 0;

        // Calculate operations required to make all elements equal to median
        for (int num : values) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        int[][] grid1 = {{2, 4}, {6, 8}};
        int x1 = 2;
        System.out.println(solver.minOperations(grid1, x1)); // Output: 4

        int[][] grid2 = {{1, 5}, {2, 3}};
        int x2 = 1;
        System.out.println(solver.minOperations(grid2, x2)); // Output: 5

        int[][] grid3 = {{1, 2}, {3, 4}};
        int x3 = 2;
        System.out.println(solver.minOperations(grid3, x3)); // Output: -1
    }
}
