class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int[] p: points){
            int d = p[0]*p[0] + p[1]*p[1];
            pq.offer(new int[]{-d, p[0], p[1]});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] cur = pq.poll();
            res[i][0] = cur[1];
            res[i][1] = cur[2];
        }
        return res;

    }
}