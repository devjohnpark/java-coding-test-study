class Solution {
    static List<String> result;
    static Map<Integer, String> map;

    public List<String> letterCombinations(String digits) {
        map = new HashMap();
        initMap();

        result = new ArrayList<>();

        if (digits.length() != 0) {
            backTracking(0, "", digits);
        }
        
        return result;
    }

    public void backTracking(int pick, String making, String digits) {
        if (pick == digits.length()) {
            result.add(making);
            return;
        }

        String letters = map.get(Integer.parseInt(digits.substring(pick, pick+1)));

        for(int i=0; i < letters.length(); i++) {
            backTracking(pick + 1, making + letters.charAt(i), digits);
        }
    }

    public void initMap() {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }
}