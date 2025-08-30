class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<jewels.length(); i++) {
            map.put(jewels.charAt(i), 1);
        }

        int result = 0;
        for(int i=0; i<stones.length(); i++) {
            result += (map.get(stones.charAt(i)) == null) ? 0 : map.get(stones.charAt(i));
        }

        return result;
    }
}