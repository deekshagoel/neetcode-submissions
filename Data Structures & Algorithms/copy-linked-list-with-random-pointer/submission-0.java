/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> oldtoNew = new HashMap();
        oldtoNew.put(null, null);

        Node curr = head;
        while(curr!=null){
            Node node = new Node(curr.val);
            oldtoNew.put(curr, node);
            curr = curr.next;
        }

        curr = head;
        while(curr!=null){

            Node copy = oldtoNew.get(curr);
            copy.next = oldtoNew.get(curr.next);
            copy.random = oldtoNew.get(curr.random);
            curr=curr.next;
        }

        return oldtoNew.get(head);
    }
}
