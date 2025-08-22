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

        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.val > o2.val) {
                return 1;
            } else if (o1.val < o2.val) {
                return -1;
            } else {
                return 0;
            }
        });

        for(int i=0; i<lists.length; i++) {
            ListNode node = lists[i];  

            while(node != null) {
                pq.offer(node);
                node = node.next;
            }
        }

        if (pq.size() == 0) {
            return null;
        } 
        
        ListNode result = pq.peek();

        ListNode node = null;;
        while(!pq.isEmpty()) {
            node = pq.poll();

            node.next = pq.peek();
        }

        node.next = null;

        return result;
    }
}