class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<>();

        map.put( ')', '(');
        map.put( '}', '{');
        map.put( ']', '[');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) {
                stack.add(ch);
            } else if(stack.isEmpty() || map.get(ch) != stack.pop()){
                return false;
            }

        }
        return stack.isEmpty();
    }
}