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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode top = l1;
        ListNode bottom = l2;
        ListNode sum = new ListNode(0);
        ListNode placevalue = sum;
        int s = 0;
        int carry = 0;

        while(top != null || bottom != null){
            //if one is null it will give null pointer exception
            if(top == null){
                s = bottom.val + carry;
                bottom = bottom.next;
            }
            else if(bottom == null){
                s = top.val + carry;
                top = top.next;
            }
            else {
                s = top.val + bottom.val + carry;
                top = top.next;
                bottom = bottom.next;
            }

            //need to check for carryover, mod gets ones place and divide by 10 gets tens place
            if(s >= 10){
                int mod = s % 10;
                carry = s / 10;
                placevalue.next = new ListNode(mod);
            }
            else {
                placevalue.next = new ListNode(s);
                s = 0;
                carry = 0;
            }
            placevalue = placevalue.next;
        }

        //check if there is any carry left and add to front if there is
        if(carry != 0){
            placevalue.next = new ListNode(carry);
            placevalue = placevalue.next;
            carry = 0;
        }
        return sum.next;
    }
}
 