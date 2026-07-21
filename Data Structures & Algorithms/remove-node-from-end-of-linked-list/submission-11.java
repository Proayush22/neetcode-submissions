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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        ListNode left = dummy;
        left.next = head;
        ListNode right = head;
        for(int i = 0; i < n; i++){
            right = right.next;
        }
        while(right != null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        //dummy is still the null before the list so dummy.next is the head of the new list
        return dummy.next;

    }
}
