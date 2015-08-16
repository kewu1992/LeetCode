/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode p = head;
        int count = 0;
        while (p != null){
            p = p.next;
            count++;
        }
        k = k % count;
        if (k == 0)
            return head;
        count = count - k;
        
        p = head;
        while (count > 1){
            p = p.next;
            count--;
        }
        ListNode temp = p.next;
        p.next = null;
        p = temp;
        temp = head;
        head = p;
        while (p.next != null)
            p = p.next;
        p.next = temp;
        return head;
    }
}
