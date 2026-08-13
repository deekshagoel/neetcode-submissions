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
    public boolean hasCycle(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        boolean isCycle=false;
        //System.out.println(slow.val + " " + fast.val);

        while(fast!=null && fast.next!=null && fast!=slow){
            slow=slow.next;
            fast= fast.next.next;
            //System.out.println(slow.val + " " + fast.val);
        }
        if(fast!=null && slow == fast){
            isCycle = true;
        }
        return isCycle;
    }
}
