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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0, head);

        ListNode groupPrev= dummy;

        while(true){
        ListNode kth = getKth(groupPrev, k);

        if(kth == null){
            break;
        }
        ListNode curr = groupPrev.next;
        ListNode groupNext = kth.next;
        ListNode prev = groupNext;
        
        while(curr != groupNext){
            ListNode tmp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = tmp;
        }

        ListNode tmp = groupPrev.next;
        groupPrev.next = kth;
        groupPrev = tmp;
        }
        return dummy.next;
    }

    ListNode getKth(ListNode prev, int k){
        ListNode dummy = prev;
        
        while(prev!=null && k>0){
            prev = prev.next;
            k--;
        }
        return prev;
    }
}
