public class Solution {

	public static void main(String[] args) throws Exception {
		char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
		int n = 2;
		System.out.println(leastInterval(tasks, n));
	}
	public static int leastInterval(char[] tasks, int n) {
		int[] cnt = new int[26];
		int maxCnt = 0;
		int maxFrq = 0;
		for (char c : tasks) {
			int idx = c - 'A';
			cnt[idx]++;
			if (maxCnt < cnt[idx]) {
				maxCnt = cnt[idx];
				maxFrq = 1;
			} else if (maxCnt == cnt[idx])
				maxFrq++;
		}
		int windowCnt = maxCnt - 1;
		int windowLen = n + 1;
		return Math.max(tasks.length, windowCnt * windowLen + maxFrq);
	}
}