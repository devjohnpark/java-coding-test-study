import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Solution {

	public static void main(String[] args) throws Exception {
		int numCourses = 2;
		int[][] prerequisites = {{1, 0}, {0, 1}};
		System.out.println(canFinish(numCourses, prerequisites));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int[] indegree = new int[numCourses];
		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++)
			graph.add(new ArrayList<>());
		for (int[] prerequisite : prerequisites) {
			int s = prerequisite[0], e = prerequisite[1];
			graph.get(s).add(e);
			indegree[e]++;
		}
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < numCourses; i++)
			if (indegree[i] == 0)
				dq.offer(i);
		while (!dq.isEmpty()) {
			int s = dq.poll();
			numCourses--;
			visited[s] = true;
			for (int e : graph.get(s)) {
				if (visited[e])
					continue;
				if (--indegree[e] == 0)
					dq.offer(e);
			}
		}
		return numCourses == 0;
	}
}
// 위상 정렬