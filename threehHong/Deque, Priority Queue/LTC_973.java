// 973. K Closest Points to Origin(원점에 가장 가까운 k개의 점)

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // 주어진 점과 원점 사이의 거리(직선)
        for(int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            int dist = x*x + y*y; 

            // (a, b) -> a[0] - b[0] 이므로 거리가 가장 가까운 배열 부터 반환
            pq.add(new int[]{dist, i});
        }

        // k의 개수만큼 우선 순위 큐에서 꺼내 반환
        int[][] answer = new int[k][2];

        for(int i = 0; i < k; i++) {
            int[] item = pq.poll();
            int idx = item[1];
            answer[i] = points[idx];
        }

        return answer;
    }
}