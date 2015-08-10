/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int len = 1;
        while (p.next != null){
            len++;
            p = p.next;
        }
        int offset = len - n;
        if (offset == 0)
            return head.next;
        p = head;
        while (offset > 1){
            offset--;
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }
}
