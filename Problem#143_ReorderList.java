/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        if (p2 != null)
            p1 = p1.next;
        ListNode newHead = null;
        while (p1 != null){
            ListNode temp = p1.next;
            p1.next = newHead;
            newHead = p1;
            p1 = temp;
        }
        p1 = head;
        p2 = newHead;
        while (p2 != null){
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;
        }
        if (p1 != null)
            p1.next = null;
    }
}
