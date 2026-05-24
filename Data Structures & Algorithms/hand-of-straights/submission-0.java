class Solution {

    public class Node{
        int val;
        Node next;
        Node prev;

        Node(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public void del(Node root){
        Node p = root.prev;
        Node n = root.next;
        p.next = n;
        if(n != null) n.prev = p;
    }

    public boolean isNStraightHand(int[] hand, int gs) {
        Arrays.sort(hand);
        Node dummy = new Node(-1);
        Node temp = dummy;

        for(int h: hand){
            Node a = new Node(h);
            temp.next = a;
            a.prev = temp;
            temp = a;
        }

        while(dummy.next != null){
            int siz = gs;
            Node t = dummy.next;
            int strt = t.val;
            Node s = dummy.next;

            while(dummy.next != null && siz > 0){
                if(siz == 1){
                    siz = 0;
                    del(t);
                    break;
                }
                while(t != null && t.val != strt+1){
                    t = t.next;
                }
                if(t == null) return false;
                strt = t.val;

                siz--;
                del(s);

                s = t;
            }
            if(dummy.next == null && siz != 0) return false;
        }

        return true;
    }
}
