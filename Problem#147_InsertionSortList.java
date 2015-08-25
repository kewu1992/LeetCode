/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        
        ListNode p = head, pPre = null;
        while (p != null){
            ListNode q = newHead;
            while (q.next != p && q.next.val < p.val)
                q = q.next;
            if (q.next != p) {
                pPre.next = p.next;
                ListNode tempNext = p.next;
                p.next = q.next;
                q.next = p;
                p = tempNext;
            } else {
                pPre = p;
                p = p.next;
            }
        }
        
        return newHead.next;
    }
}
