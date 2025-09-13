import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) throws Exception {
		int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
		int n = 4, k = 2;
		System.out.println(networkDelayTime(times, n, k));
	}

	public static int networkDelayTime(int[][] times, int n, int k) {
		ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++)
			graph.add(new ArrayList<>());
		for (int i = 0; i < times.length; i++)
			graph.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = dist[k] = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> dist[o1] - dist[o2]);
		pq.offer(k);
		boolean[] isVisited = new boolean[n + 1];
		while (!pq.isEmpty()) {
			int u = pq.poll();
			if (isVisited[u])
				continue;
			isVisited[u] = true;
			for (int[] edge : graph.get(u)) {
				int v = edge[0];
				int w = edge[1];
				if (!isVisited[v] && dist[u] + w < dist[v]) {
					dist[v] = dist[u] + w;
					pq.offer(v);
				}
			}
		}
		int maxW = 0;
		for (int w : dist) {
			if (w == Integer.MAX_VALUE)
				return -1;
			maxW = Math.max(maxW, w);
		}
		return maxW;
	}
}
// 다익스트라