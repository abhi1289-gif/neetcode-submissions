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

    public ListNode reverse(ListNode root){

        if(root == null || root.next == null) return root;

        ListNode prev = null;
        ListNode temp = root;

        while(temp != null){
            ListNode nxt = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nxt;
        }

        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int pos = 1;
        ListNode prev = dummy;
        ListNode a = head;

        while(pos < left){
            prev = a;
            a = a.next;
            pos++;
        }

        ListNode b = a;

        while(pos < right){
            b = b.next;
            pos++;
        }

        ListNode nxt = b.next;
        prev.next = null;
        b.next = null;
        b = reverse(a);

        prev.next = b;
        a.next = nxt;

        return dummy.next;
    }
}