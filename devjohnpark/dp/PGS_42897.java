class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        if (n == 1) return money[0];

        // case1: 첫 집 포함 가능 (마지막 집 제외)
        int case1 = robLinear(money, 0, n - 2);
        
        // case2: 첫 집 제외 (마지막 집 포함 가능)
        int case2 = robLinear(money, 1, n - 1);

        return Math.max(case1, case2);
    }
    
    private int robLinear(int[] nums, int start, int end) {
        int len = end - start + 1;

        int[] dp = new int[len];
        
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        return dp[len - 1];
    }
}
