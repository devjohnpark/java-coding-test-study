class Solution {

    private int m, n;
    private boolean[][] visited;

    public int numIslands(char[][] grid) {

        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (grid[i][k] == '1' && ! visited[i][k]) {
                    dfs(i, k, grid);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int x, int y, char[][] grid) {
        if (x<0 || y<0 || x>=m || y>=n) return;
        if (grid[x][y] == '0' || visited[x][y]) return;

        visited[x][y] = true;
        dfs(x+1, y, grid);
        dfs(x-1, y, grid);
        dfs(x, y+1, grid);
        dfs(x, y-1, grid);
    }
}
