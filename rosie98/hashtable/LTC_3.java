class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        int length = 0;
        int left = 0;
        int right = 0;
        char[] arr = s.toCharArray();

        while(right < s.length()) {
            if (map.get(arr[right]) == null) {
                map.put(arr[right], 1);
            } else {
                map.put(arr[right], map.get(arr[right]) + 1);
            }
            
            if (map.get(arr[right]) > 1) {
                while(map.get(arr[right]) != 1) {
                    map.put(arr[left], map.get(arr[left]) - 1); 
                    left++;
                    length--;
                }
            }

            length++;
            right++;
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}