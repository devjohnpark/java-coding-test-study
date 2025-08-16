// 316. Remove Duplicate Letters(중복 문자 제거)

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];

        // 1. 각 문자의 등장 횟수 미리 카운트
        // 'a' -> 97
        // (문자 - 'a') -> 알파벳에서 현재 문자의 순번
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        Stack<Character> stack = new Stack<>();

        // 2. 문자열 순회
        for(char c : s.toCharArray()) {
            int idx = c - 'a'; // 현재 문자의 인덱스 번호
            count[idx]--;

            // 이미 스택에 있는 문자라면 건너뛴다
            if(visited[idx]) {
                System.out.println("skip: " + c + " (이미 스택에 있음)");
                continue;
            }

            // pop 조건: 스택이 비어있지 않고, top > 현재 문자 이고, top이 뒤에서 다시 등장한다면
            while(!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                char removed = stack.pop();
                visited[removed - 'a'] = false; 
                System.out.println("pop: " + removed + " (뒤에서 다시 나오고 " + c + "가 더 작음)");
            }

            // 현재 문자 push
            stack.push(c);
            visited[idx] = true;
        }

        // 3. 스택은 역순이므로 뒤집기
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}