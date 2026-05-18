class Solution {

    public ListNode reverse(ListNode root){
        if(root == null || root.next == null) return root;
        ListNode temp = root;
        ListNode prev = null;

        while(temp != null){
            ListNode a = temp;
            temp = temp.next;
            a.next = prev;
            prev = a;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = head;
        ListNode prev = dummy;

        while(temp != null){
            int a = k;
            ListNode nxtprev = temp;
            while(temp != null && a > 1){
                temp = temp.next;
                a--;
            }
            if(temp == null) break;
            ListNode nxt = temp.next;
            temp.next = null;
            ListNode newHead = reverse(nxtprev);
            prev.next = newHead;
            while(newHead.next != null) newHead = newHead.next;
            newHead.next = nxt;

            prev = newHead;
            temp = nxt;
        }

        return dummy.next;
    }
}
