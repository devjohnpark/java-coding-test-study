class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        int[] visited = new int[numCourses]; // 0=미방문, 1=방문중, 2=방문완료
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCycle(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] visited, int node) {
        if (visited[node] == 1) return true;   // 방문 중 다시 만남 = 사이클
        if (visited[node] == 2) return false;  // 이미 완료된 노드

        visited[node] = 1; // 방문 중
        for (int next : graph.get(node)) {
            if (hasCycle(graph, visited, next))
                return true;
        }
        visited[node] = 2; // 방문 완료
        return false;
    }
}
