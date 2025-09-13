import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws Exception {
		int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
		int n = 4, src = 0, dst = 3, k = 1;
		System.out.println(findCheapestPrice(n, flights, src, dst, k));
	}

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		for (int i = 0; i <= k; i++) {
			int[] temp = Arrays.copyOf(dist, n);
			for (int[] flight : flights)
				if (dist[flight[0]] != Integer.MAX_VALUE && temp[flight[1]] > dist[flight[0]] + flight[2])
					temp[flight[1]] = dist[flight[0]] + flight[2];
			dist = temp;
		}
		return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
	}
}
// 벨만포드
// BFS도 가능할듯