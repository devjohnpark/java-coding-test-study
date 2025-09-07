import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
	static int n, m;

	public static void main(String[] args) throws Exception {
		char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', 1}};
		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {
		n = grid.length;
		m = grid[0].length;
		int cnt = 0;
		Deque<int[]> dq;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					grid[i][j] = '0';
					cnt++;
					dq = new ArrayDeque<>();
					dq.offer(new int[]{i, j});
					while (!dq.isEmpty()) {
						int[] cur = dq.poll();
						int y = cur[0], x = cur[1];
						for (int k = 0; k < 4; k++) {
							int ny = y + dy[k], nx = x + dx[k];
							if (isValid(ny, nx) && grid[ny][nx] == '1') {
								grid[ny][nx] = '0';
								dq.offer(new int[]{ny, nx});
							}
						}
					}
				}
			}
		return cnt;
	}

	private static boolean isValid(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < m;
	}
}
