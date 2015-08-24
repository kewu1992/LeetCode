/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        boolean flag = false;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                flag = true;
                break;
            }
        }
        if (!flag)
            return null;
        p2 = head;
        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
