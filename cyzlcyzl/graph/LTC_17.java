class Solution {

    private String[] phoneNumbers = {
        "", "", "abc", "def", "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) return result;
        dfs(digits, 0, new StringBuilder(), result);

        return result;
    }

    public void dfs(String digits, int index, StringBuilder sb, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int num = digits.charAt(index) - '0';
        for (char c : phoneNumbers[num].toCharArray()){
            sb.append(c);
            dfs(digits, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

