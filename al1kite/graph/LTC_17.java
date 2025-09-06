class Solution {

    private static final String[] phone = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        dfs(digits, 0, "", result);
        return result;
    }

    private void dfs(String digits, int idx, String path, List<String> result) {
        if (idx == digits.length()) {
            result.add(path);
            return;
        }

        String letters = phone[digits.charAt(idx) - '0'];
        for (char c : letters.toCharArray()) {
            dfs(digits, idx + 1, path + c, result);
        }
    }
}