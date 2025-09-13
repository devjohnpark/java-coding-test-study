import java.util.*;

class Solution {
    int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        
        bfs(0, 0, maps);
        
        return maps[maps.length-1][maps[0].length-1] == 1 ? 
            -1 : maps[maps.length-1][maps[0].length-1];
    }
    
    public void bfs(int x, int y, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for(int i=0; i<move.length; i++) {
                int mx = current[0] + move[i][0];
                int my = current[1] + move[i][1];
                
                if (mx > -1 && my > -1 && mx < maps.length && my < maps[0].length &&
                    !visited[mx][my] && maps[mx][my] != 0) {
                    visited[mx][my] = true;
                    
                    if (maps[mx][my] == 1) {
                        maps[mx][my] += maps[current[0]][current[1]];
                    } else {
                        maps[mx][my] = Math.min(maps[mx][my], maps[current[0]][current[1]] + 1);
                    }
                    
                    queue.offer(new int[]{mx, my});
                }
            }
        }
    }
}