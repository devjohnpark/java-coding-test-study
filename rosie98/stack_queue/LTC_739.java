import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] answer = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        
        for(int i=temperatures.length-1; i>-1; i--) {
            while(!stack.isEmpty()) {
                if (temperatures[i] < temperatures[stack.peek()]) {
                    answer[i] = stack.peek() - i;
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.push(i);
        }

        return answer;
    }
}