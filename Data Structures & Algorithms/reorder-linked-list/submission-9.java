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

        //fast != null is for odd numbers and fast.next != null is for even numbers this puts slow at the half and fast at the part that needs to be reversed
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
        //this makes prev the head, reversing the list

        slow.next = null;
        //this is to sever the list


        ListNode first = head;
        ListNode second = prev;
        
        while(second != null){
            // 1. Save the next nodes
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            
            // 2. Link first to second
            first.next = second;
            
            // 3. Link second to the rest of the first half
            second.next = tmp1;
            
            // 4. Move pointers forward
            first = tmp1;
            second = tmp2;
        }

        /*
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
        */

    }
}
