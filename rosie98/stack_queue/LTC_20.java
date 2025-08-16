import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();

        for(int i=0; i<s.length(); i++) {
            if (!deque.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')) {
                if (checkMatching(deque.getLast(), s.charAt(i))) {
                    deque.pollLast();
                } else {
                    return false;
                }
            } else {
                deque.offer(s.charAt(i));
            }
        }
        
        return deque.isEmpty();
    }

    public boolean checkMatching(char left, char right) {
        return ((left == '(' && right == ')') ||
                (left == '{' && right == '}') ||
                (left == '[' && right == ']')) ? true : false;
    }
}