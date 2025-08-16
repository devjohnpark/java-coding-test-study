// 20. Valid Parentheses(유효한 괄호)

class Solution {
    public boolean isValid(String s) {        
        Stack<Character> stack = new Stack<>();

        Boolean result = true;
        
        for(char c : s.toCharArray()) {
            // 괄호가 열림일 경우 -> 스택에 추가
            if(c == '(' || c == '{' || c == '[') { 
                stack.push(c);
                continue;
            }

            // 괄호가 닫힘일 경우 -> 스택에 추가
            if(c == ')' || c == '}' || c == ']') {
                // 단, 스택이 비어있으면 -> false 반환 및 반복문 종료
                if(stack.isEmpty()) {
                    result = false;
                    break;
                }

                // 이전에 추가한 괄호가 타입과 새롭게 추가되는 괄호 타입 비교해서 맞으면 현재 스택의 top 저장된 데이터 제거
                if(stack.peek() == '(' && c == ')' || stack.peek() == '{' && c == '}' || stack.peek() == '[' && c == ']') {
                    stack.pop();
                    continue;
                } else {
                    // 이전에 추가한 괄호 타입과 일치한 타입이 없을 경우 -> false 반환 및 반복문 종료
                    result = false;
                    break;
                }
            }   
        }
        
        // 반복문이 종료 되었는데 스택이 비어있지 않을 경우 -> false 반환 및 반복문 종료
        // ex. ( or { or [ or (( or {{ or [[ 등일 경우
        if(!stack.isEmpty()) {
            result = false;
        }

        return result;
    }
}