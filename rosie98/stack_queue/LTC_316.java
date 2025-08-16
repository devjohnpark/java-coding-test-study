class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        for(int i=0; i<s.length(); i++) {
            if (sb.toString().indexOf(s.charAt(i)) != -1) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                continue;
            }

            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {    
                while(!stack.isEmpty() && stack.peek() > s.charAt(i) && map.get(stack.peek()) > 1) {
                    map.put(stack.peek(), map.get(stack.peek()) - 1);
                    stack.pop();
                    sb.deleteCharAt(sb.toString().length() - 1);
                }

                stack.push(s.charAt(i));
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}