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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        //fast != null is for odd numbers and fast.next != null is for even numbers
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverse = slow.next;
        ListNode prev = null;
        while(reverse != null){
            ListNode next = reverse.next;
            reverse.next = prev;
            prev = reverse;
            reverse = next;
        }
        slow.next = null;
        //this makes prev the head

        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode start = head;
        while(prev != null && start != null){
            tail.next = start;
            start = start.next;
            tail = tail.next;
            tail.next = prev;
            prev = prev.next;
            tail = tail.next;
        }
        if(start != null){
            tail.next = start;
        }

    }
}
