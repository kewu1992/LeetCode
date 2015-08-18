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
        ListNode p, q;
        p = newHead;
        q = p.next;
        while(q != null){
            int val = q.val;
            if (q.next != null && val == q.next.val){
                while (q.next != null && val == q.next.val)
                    q = q.next;
                p.next = q.next;
            } else{
                p = p.next;
            }
            q = p.next;
        }
        return newHead.next;
    }
}
