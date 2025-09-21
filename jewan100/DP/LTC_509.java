public class Solution {

	public static void main(String[] args) throws Exception {
		System.out.println(fib(30));
	}

	static int[] dp = new int[31];

	public static int fib(int n) {
		if (n <= 1)
			return n;
		if (dp[n] != 0)
			return dp[n];
		return dp[n] = fib(n - 1) + fib(n - 2);
	}
}