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
        Node temp1 = head;

        Node dummy = new Node(0);
        Node travel = dummy;

        while(temp1 != null){
            Node a = new Node(temp1.val);
            travel.next = a;

            temp1 = temp1.next;
            travel = travel.next;
        }
        Node result = dummy.next;
        Node temp2 = result;
        int i = 0;
        temp1 = head;

        while(temp1 != null){
            Node a = temp1.random;

            if(a == null){
                temp1 = temp1.next;
                temp2 = temp2.next;
                continue;
            }

            Node b = result;
            Node c = head;

            while(c != a){
                c = c.next;
                b = b.next;
            }
            
            temp2.random = b;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return result;
    }
}
