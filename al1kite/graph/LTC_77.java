class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0) {
            res.add(new ArrayList<>());
            return res;
        }

        Queue<List<Integer>> q = new ArrayDeque<>();
        q.offer(new ArrayList<>());

        while (!q.isEmpty()) {
            List<Integer> cur = q.poll();

            if (cur.size() == k) {
                res.add(cur);
                continue;
            }

            int start = cur.isEmpty() ? 1 : cur.get(cur.size() - 1) + 1;
            int need = k - cur.size();

            for (int i = start; i <= n - need + 1; i++) {
                List<Integer> next = new ArrayList<>(cur);
                next.add(i);
                q.offer(next);
            }
        }
        return res;
    }
}