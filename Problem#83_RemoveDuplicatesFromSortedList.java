/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        ListNode q = p.next;
        while (q != null){
            while (q.next != null && q.next.val == q.val)
                q = q.next;
            p.next = q;
            p = p.next;
            q = p.next;
        }
        return newHead.next;
    }
}
