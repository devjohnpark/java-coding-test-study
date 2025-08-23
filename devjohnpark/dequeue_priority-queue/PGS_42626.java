import java.util.*;

class Solution {    
    public int solution(int[] scoville, int K) {
        int answer = 0;

		// 1. `PriorityQueue`을 최소힙으로 생성한다.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 디폴트 오름차순

		// 2. 배열을 순회하면서 우선순위큐에 넣는다.
        for (int n: scoville) {
            minHeap.add(n);
        }

		// 3. 우선순위큐가 비지않거나 가장 작은 값이 `K`보다 작으면 반복한다.
        while (!minHeap.isEmpty() && minHeap.peek() < K) {
	        // 4. 우선순위큐의 크기가 2보다 작으면, K 이상으로 만들 수 없으므로 -1을 반환한다.
            if (minHeap.size() < 2) return -1; 

			// 5. 우선순위큐에서 가장 작은 2개의 값을 차례로 삭제해서 공식에 대입한 새로운 값으로 만든다.
            int min1 = minHeap.remove(); // 가장 작은 값
            int min2 = minHeap.remove(); // 두번째로 가장 작은 값

			// 6. 새로운값을 다시 우선순위큐에 넣는다.
            minHeap.add(min1 + (min2 * 2)); 
        
	        // 7. 공식을 대입한 회수를 카운팅한다.
            answer++; 
        }
        // 8. 카운팅한 회수를 반환한다.
        return answer;
    }
}
