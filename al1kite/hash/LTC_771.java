class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        Map<Character, Integer> hash = new HashMap<>();
        int answer = 0;

        for(char stone : stones.toCharArray()){
            if(hash.containsKey(stone)){
                hash.replace(stone, hash.get(stone) + 1);
            } else {
                hash.put(stone, 1);
            }
        }

        for(char jewel : jewels.toCharArray()){
            if(hash.containsKey(jewel)){
                answer += hash.get(jewel);
            }
        }

        return answer;
    }
}