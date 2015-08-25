/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null){
            p = p.next;
            count++;
        }
        if (count == 0)
            return null;
        head = sort(head, count);
        p = head;
        while (count > 1){
            p = p.next;
            count--;
        }
        p.next = null;
        return head;
    }
    
    private ListNode sort(ListNode head, int nodeCount){
        if (nodeCount == 1)
            return head;
        if (nodeCount == 2){
            if (head.val < head.next.val)
                return head;
            else {
                head.next.next = head;
                return head.next;
            }
        }
        
        ListNode p1 = head, p2 = head;
        int count = 0;
        while (nodeCount > 1){
            p1 = p1.next;
            p2 = p2.next.next;
            nodeCount -= 2;
            count++;
        }
        int p1Count, p2Count;
        if (nodeCount == 0){
            p1Count = count;
            p2Count = count;
        } else {
            p1Count = count;
            p2Count = count+1;
        }
        
        p2 = sort(p1, p2Count);
        p1 = sort(head, p1Count);
        
        ListNode tempHead = new ListNode(0);
        ListNode p3 = tempHead;
        
        while (p1Count > 0 && p2Count > 0){
            if (p1.val < p2.val){
                p3.next = p1;
                p3 = p3.next;
                p1 = p1.next;
                p1Count--;
            } else {
                p3.next = p2;
                p3 = p3.next;
                p2 = p2.next;
                p2Count--;
            }
        }
        if (p1Count > 0 || p2Count > 0){
            if (p1Count > 0)
                p3.next = p1;
             else if (p2Count > 0)
                p3.next = p2;
        }
        
        return tempHead.next;
    }
}
