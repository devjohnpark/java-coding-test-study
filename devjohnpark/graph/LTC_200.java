class Solution {
    // 섬 개수 발견 메서드
    // 주어진 2차원 배열에서 순회하면서 지점한 점을 시작으로 재귀 메서드를 한번 호출하고 나서 카운팅을하여 마지막에 반환한다.
    public int numIslands(char[][] grid) {
        int cnt = 0;
        // 2차원 배열의 모든 시작으로 탐색을 진행 
        int n = grid.length; // 2차원 배열의 row 
        int m = grid[0].length; // 2차원 배열의 column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 1을 발견하면 탐색 시작
                if (grid[i][j] == '1') {
                    dfsRursive(grid, i, j); // i, j 지점부터 시작해서 수평, 수직 방향으로 dfs 탐색
                    cnt++; // dfs 호출은 재귀적으로 수평, 수직 방향으로 탐색하므로 1으로 시작해서 0이나 끝점에 도달하면 탐색이 종료되어 카운팅을 해준다.
                } 
            }
        }
        return cnt;
    }   

    // 재귀 dfsR 메서드
    // dfs(int grid[][], int x, int y): 이차원 배열에 전달된 요소를 시발점으로 탐색 필요
    // 종료 시점: 0에 도달했거나 배열 끝점에 도달했을때
    // 방문 표시: 재귀 메서드 종료 조건인 0으로 변경
    // 동작: 1을 발견하면 수직과 수평 방향으로 탐색한다. 이차원 배열에서 (x+1,y), (x-1,y), (x,y-1), (x,y+1)을 시발점으로 dfs 탐색 호출
    private void dfsRursive(char grid[][], int x, int y) {
        int n = grid.length; // 2차원 배열의 row 
        int m = grid[0].length; // 2차원 배열의 column
        
        // 재귀 메서드로 호출되므로 0이나 끝점에 도달할시 종료해야한다. (재귀 메서드 탈출 조건)
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == '0') return;

        // 방문 표시 (모든 배열 요소를 시발점으로 탐색하므로 중복 탐색을 할수있다.)
        grid[x][y] = '0'; // bfs 탈출 조건의 값으로 변경

        // 주어진 지점으로 부터 수직 수평 방향으로 탐색 (십자가 방향)
        dfsRursive(grid, x - 1, y);
        dfsRursive(grid, x + 1, y);
        dfsRursive(grid, x, y - 1);
        dfsRursive(grid, x, y + 1);
    }
}
