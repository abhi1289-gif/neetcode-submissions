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
        Node temp = head;

        HashMap<Node, Node> mapp = new HashMap<>();

        while(temp != null){
            mapp.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;

        while(temp != null){
            Node cpy = mapp.get(temp);

            cpy.next = mapp.get(temp.next);
            cpy.random = mapp.get(temp.random);

            temp = temp.next;
        }

        return mapp.get(head);
    }
}
