import java.util.*;

class Solution {
    private int m, n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    bfs(grid, r, c);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int sr, int sc) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        grid[sr][sc] = '0';

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1') {
                    grid[nr][nc] = '0';
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
