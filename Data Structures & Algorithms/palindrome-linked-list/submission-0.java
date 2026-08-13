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
    ListNode dummy; 
public boolean isPalindrome(ListNode head) {
    dummy=head;
    return rec(head);
}

    public boolean rec(ListNode head) {
        if(head == null){
            return true;
        }

        if(rec(head.next)){
            if(dummy.val==head.val){
                dummy=dummy.next;
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}