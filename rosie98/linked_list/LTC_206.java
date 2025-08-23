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

import java.util.*;

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        Deque<Integer> deque = new LinkedList<>();   

        while(head != null) {
            deque.offer(head.val);
            head = head.next;
        }

        ListNode node = new ListNode(deque.pollLast());

        ListNode result = node;

        while(!deque.isEmpty()) {
            int val = deque.pollLast();

            ListNode newNode= new ListNode(val);
            
            node.next = newNode;
            node = newNode;
        }

        return result;
    }
}