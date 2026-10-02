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
    public ListNode mergeKLists(ListNode[] lists) {
        
        int n = lists.length;
        if(n==1){
            return lists[0];
        }
        if(n==0){
            return null;
        }

        for(int i=1; i<n ;i++){
            lists[i] = merge(lists[i-1], lists[i]);
        }
        return lists[n-1];
    }

    ListNode merge(ListNode p, ListNode q){
        ListNode dummy = new ListNode(0);
ListNode n=dummy;
        while(p!=null && q!=null){
            if(p.val <= q.val){
                n.next = p;
                p=p.next;
            }else{
                n.next = q;
                q=q.next;
            }
            n=n.next;
        }
        if(p!=null){
            n.next = p;
        }
        if(q!=null){
            n.next=q;
        }
        return dummy.next;
    }
}
