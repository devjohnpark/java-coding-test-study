class Node {
    int target;
    int time;

    public Node(int target, int time) {
        this.target= target;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> nodes = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            nodes.add(new ArrayList<>());
        }

        for(int i=0; i<times.length; i++) {
            nodes.get(times[i][0]).add(new Node(times[i][1], times[i][2]));
        }
        
        return dijkstra(times, n, k, nodes);
    }

    public int dijkstra(int[][] times, int n, int k, List<List<Node>> nodes) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.time - o2.time;
        });

        pq.offer(new Node(k, 0));
        dist[k] = 0;

        while(!pq.isEmpty()) {
            Node nowNode = pq.poll();
            
            for(Node node : nodes.get(nowNode.target)) {
                if (dist[node.target] > dist[nowNode.target] + node.time) {
                    dist[node.target] = dist[nowNode.target] + node.time;

                    pq.offer(new Node(node.target, dist[node.target]));
                }
            }
        }

        int answer = 0;
        
        for(int i=1; i<=n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            } 

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}