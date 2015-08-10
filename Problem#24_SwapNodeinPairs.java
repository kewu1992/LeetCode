/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode finalHead = new ListNode(0);
        finalHead.next = head;
        ListNode p = finalHead, temp;
        while (p.next != null && p.next.next != null){
            temp = p.next;
            p.next = temp.next;
            temp.next = p.next.next;
            p.next.next = temp;
            
            p = temp;
        }
        return finalHead.next;
    }
}
