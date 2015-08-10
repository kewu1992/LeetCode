/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p = head;
        while (p1 != null && p2 != null){
            if (p1.val < p2.val){
                ListNode temp = new ListNode(p1.val);
                p.next = temp;
                p = temp;
                p1 = p1.next;
            } else {
                ListNode temp = new ListNode(p2.val);
                p.next = temp;
                p = temp;
                p2 = p2.next;
            }
        }
        while (p1 != null || p2 != null){
            if (p1 != null){
                ListNode temp = new ListNode(p1.val);
                p.next = temp;
                p = temp;
                p1 = p1.next;
            } else {
                ListNode temp = new ListNode(p2.val);
                p.next = temp;
                p = temp;
                p2 = p2.next;
            }
        }
        return head.next;
    }
}
