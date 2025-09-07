import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<String, PriorityQueue<String>>();

        for (int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];

            if (!graph.containsKey(from)) {
                graph.put(from, new PriorityQueue<String>());
            }
            graph.get(from).add(to);
        }

        LinkedList<String> result = new LinkedList<String>();
        dfs("ICN", graph, result);

        // LinkedList → 배열 변환
        String[] answer = new String[result.size()];
        return result.toArray(answer);
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> result) {
        PriorityQueue<String> nextAirports = graph.get(airport);

        while (nextAirports != null && !nextAirports.isEmpty()) {
            String next = nextAirports.poll();
            dfs(next, graph, result);
        }

        result.addFirst(airport);
    }
}

