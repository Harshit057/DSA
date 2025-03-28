import java.util.*;

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int k = queries.length;
        int[] result = new int[k];
        
        // Sorting queries and keeping track of their original indices
        int[][] queryWithIndex = new int[k][2];
        for (int i = 0; i < k; i++) {
            queryWithIndex[i][0] = queries[i];
            queryWithIndex[i][1] = i;
        }
        Arrays.sort(queryWithIndex, Comparator.comparingInt(a -> a[0]));
        
        // Min-Heap (Priority Queue) for processing grid cells in increasing order of value
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        
        int count = 0, index = 0;
        int[] directions = {-1, 0, 1, 0, -1};
        
        while (index < k) {
            int currentQuery = queryWithIndex[index][0];
            
            // Process all cells with value < currentQuery
            while (!pq.isEmpty() && pq.peek()[0] < currentQuery) {
                int[] cell = pq.poll();
                int val = cell[0], r = cell[1], c = cell[2];
                count++;
                
                // Explore 4 possible directions
                for (int d = 0; d < 4; d++) {
                    int nr = r + directions[d], nc = c + directions[d + 1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        pq.offer(new int[]{grid[nr][nc], nr, nc});
                    }
                }
            }
            
            // Store the result for the current query index
            result[queryWithIndex[index][1]] = count;
            index++;
        }
        
        return result;
    }
}