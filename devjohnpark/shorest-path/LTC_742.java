class Solution {
    private static final int INF = 1_000_000_000;

    public int networkDelayTime(int[][] times, int n, int k) {
        // 1) 인접 행렬: 기본 INF, 자기자신 0
        int[][] a = new int[n][n]; // 도달해야되는 노드가 n개 이므로 n x n 매트릭스 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(a[i], INF); // 배열 a[i]의 모든 요소(열) 를 INF 값으로 채워 넣는 방식
            a[i][i] = 0; // 자기 자신으로 가는 경로는 거리 0으로 설정
        }

        // 2) 간선 채우기
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0] - 1; // 인접행렬의 인덱스로 쓸것이므로 -1 
            int v = times[i][1] - 1; // 인접행렬의 인덱스로 쓸것이므로 -1 
            int w = times[i][2]; 
            a[u][v] = w;
        }

        boolean[] v = new boolean[n];
        int[] d = new int[n];
        dijkstra(k - 1, a, n, v, d);

        // 3) 결과 계산: 도달 못한 노드 있으면 -1, 아니면 최댓값 반환
        int max = 0;
        for (int dist: d) {
            if (dist >= INF) return -1; // 도달 못한 노드
            if (dist > max) max = dist; // 가장 마지막에 신호를 받은 노드의 비용을 반환해야하므로 최대값 반환
        }
        return max;
    }

    private int getSmallIndex(boolean v[], int d[], int n) {
        int min = INF;
        int index = 0;
        // 모두 순차적으로 탐색: 선형 탐색 -> 가장 쉽게 다익스트라 구현 (가장 효율적이지는 않음)
        for (int i = 0; i < n; i++) {
            if (!v[i] && d[i] < min) {
                min = d[i];
                index = i;
            }
        }
        return index;
    }

    private void dijkstra(int start, int[][] a, int n, boolean[] v, int[] d) {
        for (int i = 0; i < n; i++) {
            d[i] = a[start][i]; // 시작점으로부터 출발했을때 모든 경로에 대해 거리 저장
        }

        v[start] = true; // 시작점 방문했다고 마킹

        for (int i = 0; i < n; i++) {
            int current = getSmallIndex(v, d, n);
            v[current] = true;

            for (int j = 0; j < n; j++) {
                if (!v[j] && d[current] + a[current][j] < d[j]) {
                    d[j] = d[current] + a[current][j]; // 작은 값으로 갱신
                }
            }
        }
    }
}
