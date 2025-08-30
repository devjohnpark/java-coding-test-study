class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<stones.length(); i++) {
            if (map.get(stones.charAt(i)) == null) {
                map.put(stones.charAt(i), 1);
            } else {
                map.put(stones.charAt(i), map.get(stones.charAt(i)) + 1);
            }
        }

        int result = 0;
        for(int i=0; i<jewels.length(); i++) {
            result += (map.get(jewels.charAt(i)) == null) ? 0 : map.get(jewels.charAt(i));
        }

        return result;
    }
}