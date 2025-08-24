// programmers/코딩테스트/알고리즘 고득점 Kit/힙(heap)/더 맵게

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int answer = 0;
        
        for(int s : scoville) pq.add(s);
                
        // 큐에 원소가 하나도 없을 경우
        if(pq.isEmpty()) return - 1;
                        
        // 큐의 최소값이 K보다 작을 경우 반복
        while(pq.size() >= 2 && pq.peek() < K) {            
            int first = pq.poll();
            int second = pq.poll();
            
            pq.add(first + second * 2);
            answer++;
        }
        
        // 다 섞고나서 최소값이 K보다 작을 경우 -1 반환
        return pq.peek() >= K ? answer : -1;
    }
}