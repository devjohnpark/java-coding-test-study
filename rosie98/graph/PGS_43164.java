class Solution {
    boolean[] visited;
    String result;
    
    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN ", tickets);
        
        String[] answer = result.split(" ");
        return answer;
    }
    
    public void dfs(int pick, String start, String str, String[][] tickets) {
        if (pick == tickets.length) {
            if (result == null || result.compareTo(str) > 0) {
                result = str;
            } 
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(pick + 1, tickets[i][1], str + tickets[i][1] +" " , tickets);
                visited[i] = false;
            }
        }
    }
}