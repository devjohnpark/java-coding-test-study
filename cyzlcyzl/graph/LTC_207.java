import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph.get(pre).add(course);
        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, graph, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int course, List<List<Integer>> graph, int[] visited) {
        if (visited[course] == 1) return false; 
        if (visited[course] == 2) return true;

        visited[course] = 1;
        for (int next : graph.get(course)) {
            if (!dfs(next, graph, visited)) {
                return false;
            }
        }
        visited[course] = 2;
        return true;
    }
}

