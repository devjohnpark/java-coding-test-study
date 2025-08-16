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
    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } 
        
        ListNode root = head;
        ListNode result = root.next;
        
        if (head.next.next == null) {
            ListNode temp = head.next;
            temp.next = head;
            head.next = null; 
        } else {
            recursion(head, null);
        }

        return result;
    }

    public void recursion(ListNode head, ListNode preNode) {
        if (head.next == null) {
            return;
        }

        if (head.next.next == null) {
            ListNode temp = head.next;
            preNode.next = temp;
            temp.next = head;
            head.next = null;
            return;
        }

        ListNode temp = head.next; 
        head.next = temp.next;
        temp.next = head;

        if (preNode != null) {
            preNode.next = temp;
        }
        
        recursion(head.next, head);
    }
}