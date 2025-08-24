class Solution {

    public int[][] kClosest(int[][] points, int k) {
        if (k == points.length) {
            return points;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            double dist1 = Math.pow(o1[0], 2) + Math.pow(o1[1], 2);
            double dist2 = Math.pow(o2[0], 2) + Math.pow(o2[1], 2);

            if (dist1 > dist2) {
                return 1;
            } else {
                return -1;
            }
        });
        
        for(int i=0; i<points.length; i++) {
            pq.offer(points[i]);
        }

        int[][] result = new int[k][2];

        for(int i=0; i<k; i++) {
            result[i] = pq.poll();
        }
        
        return result;
    }
}