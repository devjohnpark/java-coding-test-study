import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIdx = new HashMap<>();
        int left = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (lastIdx.containsKey(c) && lastIdx.get(c) >= left) {
                left = lastIdx.get(c) + 1;
            }
            lastIdx.put(c, right);

            int len = right - left + 1;
            pq.offer(len);
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}