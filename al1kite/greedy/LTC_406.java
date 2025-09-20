import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            // 키가 같다면
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]); // k 오름차순
            // 아니라면
            return Integer.compare(b[0], a[0]); // 키 내림차순
        });

        List<int[]> ans = new LinkedList<>();
        for (int[] p : people) {
            ans.add(p[1], p); // 인덱스 k에 삽입
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
