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
        ListNode slow = head, fast = head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next=null;
        head2 = reverse(head2);
        while(head2!=null){
            slow = head.next;
            fast = head2.next;
            head.next=head2;
            head2.next=slow;
            head = slow;
            head2=fast;
        }
    }
    ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode tmp= head.next;
            head.next=prev;
            prev=head;
            head=tmp;
        }
        return prev;
    }
}
