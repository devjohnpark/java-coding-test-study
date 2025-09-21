class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank  += diff;
            if (tank < 0) {        // 현재 start로는 i까지 못 감
                start = i + 1;     // 다음 칸을 새 시작점으로
                tank = 0;          // 구간 리셋
            }
        }
        return total < 0 ? -1 : start;
    }
}
