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
        Deque<ListNode> dq = new ArrayDeque<>();
        ListNode temp = head;
        while(temp != null){
            dq.add(temp);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);
        temp = dummy;
        while(dq.size() > 0){
            ListNode f = dq.pollFirst();
            temp.next = f;
            temp = temp.next;
            if(dq.size() > 0){
                ListNode l = dq.pollLast();
                temp.next = l;
                temp = temp.next;
            }
        }

        temp.next = null;
    }
}
