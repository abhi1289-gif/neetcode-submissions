class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int num = 0;

        while(temp != null){
            num++;
            temp = temp.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        num -= n;
        ListNode prev = dummy;
        temp = head;
        while(num != 0){
            num--;
            temp = temp.next;
            prev = prev.next;
        }
        temp = temp.next;
        prev.next = temp;

        return dummy.next;
    }
}
