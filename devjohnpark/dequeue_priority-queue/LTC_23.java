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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 리스트들의 개수가 0개거나 null이면 null 반환
        if (lists == null || lists.length == 0) return null;
        
        // 우선순위 큐를 최소값으로 정렬하도록 생성
        // a.val < b.val 이면 음수 → a가 b보다 먼저(우선순위 높음) → 작은 값이 루트로 감
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val); 

        // 우선순위 큐에 연결리스트들의 head 삽입
        for (ListNode head: lists) {
            if (head != null) minHeap.add(head);
        }

        // 결과값 저장할 연결리스트
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        // 최소힙의 루트 노드 삭제후, 삭제한 다음 노드 삽입
        // 우선순위큐가 빌때까지 반복
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.remove();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        return dummy.next;
    }
}
