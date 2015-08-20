/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode tempHead = newHead;
        int count = 1;
        while (count < m){
            tempHead = tempHead.next;
            count++;
        }
        ListNode p = tempHead.next;
        ListNode q = p.next;
        ListNode lastNode = p;
        while (count < n){
          ListNode tempNext = q.next;
          q.next = lastNode;
          lastNode = q;
          q = tempNext;
          count++;
        }
        tempHead.next = lastNode;
        p.next = q;
        
        return newHead.next;
    }
}
