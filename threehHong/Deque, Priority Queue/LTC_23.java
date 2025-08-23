// 23. Merge k Sorted Lists(k개의 정렬 리스트 병합)

// 문제 풀이 1
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 주어진 연결 리스트를 우선순위 큐에 전부 집어 넣는다
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];   // i번째 리스트의 head
            while (node != null) {
                pq.add(node.val);
                node = node.next;
            }
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;

				// 우선순위 큐에 저장된 값을 pop 하여 새로운 연결리스트 노드에 값을 추가하고 연결한다.
        while(!pq.isEmpty()) {
           current.next = new ListNode(pq.poll());
           current = current.next;
            
        }

        return dummy.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// 문제 풀이 2
class Solution {
    public ListNode mergeKLists(ListNode[] lists) { 
        // 사용자 정의 타입은 비교 기준을 지정해줘야 한
        // (a, b) -> a.val - b.val 우선순위 큐(Priority Queue)가 내부적으로 유지하는 최소힙 정렬 규칙 파라미터
        // (a, b) -> a - b 최소 힙 (가장 작은 값이 우선순위, 오름차순)
        // (a, b) -> b - a 최대 힙 (가장 큰 값이 우선순위, 내림차순)
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode head : lists) {
            if (head != null) pq.add(head); // 각 리스트의 head만 추가
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(!pq.isEmpty()) {
            ListNode min = pq.poll();     // 가장 작은 노드 꺼냄
            current.next = min;           // 그대로 결과에 '연결'
            current = current.next;
            if (min.next != null) pq.add(min.next); // 다음 노드를 PQ에 추가
        }

        return dummy.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */