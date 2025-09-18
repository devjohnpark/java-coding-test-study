class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 1. 키 내림차순, 같은 키면 k 오름차순
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0]; // h 내림차순
            return a[1] - b[1];                   // k 오름차순
        });

        // 2. k 위치에 순서대로 삽입
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p); // 삽입 시, 해당 인덱스에 이미 값이 있으면 그 자리의 원소와 그 뒤의 모든 원소들이 한 칸씩 뒤로 밀린다.
        }

        // 3. 리스트를 배열로 변환
        return list.toArray(new int[people.length][]);
    }
}
