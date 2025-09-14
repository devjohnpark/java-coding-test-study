public class Solution {

	public static void main(String[] args) throws Exception {
		int[] gas = {1, 2, 3, 4, 5};
		int[] cost = {3, 4, 5, 1, 2};
		System.out.println(canCompleteCircuit(gas, cost));
	}
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		int total = 0;
		int s = 0, t = 0;
		for (int i = 0; i < n; i++) {
			int diff = gas[i] - cost[i];
			total += diff;
			t += diff;
			if (t < 0) {
				s = i + 1;
				t = 0;
			}
		}
		return total < 0 ? -1 : s;
	}
}
// 출발 지점 찾기