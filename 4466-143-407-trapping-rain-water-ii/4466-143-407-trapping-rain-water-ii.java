import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m < 3 || n < 3) return 0; // A pond must be enclosed by walls
        
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        // Push all boundary cells into the priority queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    pq.offer(new int[]{heightMap[i][j], i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int waterTrapped = 0, maxHeight = 0;
        
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int height = cell[0], r = cell[1], c = cell[2];
            maxHeight = Math.max(maxHeight, height);
            
            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    waterTrapped += Math.max(0, maxHeight - heightMap[nr][nc]);
                    pq.offer(new int[]{Math.max(heightMap[nr][nc], maxHeight), nr, nc});
                }
            }
        }
        
        return waterTrapped;
    }
}
