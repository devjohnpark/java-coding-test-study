class Node {
    int value;
    int count;

    Node() {}

    Node(int value, int count) {
        this.value = value;
        this.count = count;
    }
}


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o2.count - o1.count;
        });

        for(int key : map.keySet()) {
            pq.add(new Node(key, map.get(key)));
        }

        int[] result = new int[k];

        for(int i=0; i<k; i++) {
            result[i] = pq.poll().value;
        }

        return result;
    }
}