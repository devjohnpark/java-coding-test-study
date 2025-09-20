class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;                 // 지금까지 벌어들인 총 이익
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1]; // 오늘과 어제의 가격 차이
            if (diff > 0) {             // 오늘이 어제보다 비싸면
                profit += diff;         // 그만큼 이익으로 누적 (어제 사서 오늘 판 셈)
            }
        }
        return profit;
    }
}