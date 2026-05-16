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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }

        if(list1 != null) temp.next = list1;
        if(list2 != null) temp.next = list2;

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> qu = new LinkedList<>();

        for(int i=0; i<lists.length; i++){
            qu.offer(lists[i]);
        }

        while(qu.size() > 1){
            ListNode l1 = qu.peek();
            qu.poll();
            ListNode l2 = qu.peek();
            qu.poll();
            qu.offer(mergeTwoLists(l1, l2));
        }
        ListNode ans = qu.peek();
        qu.poll();
        return ans;
    }
}