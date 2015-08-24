/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode p = head;
        while (p != null){
            RandomListNode temp = new RandomListNode(p.label);
            temp.next = p.next;
            p.next = temp;
            p = temp.next;
        }
        
        p = head;
        while (p != null){
            if (p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }
        
        p = head;
        RandomListNode newHead = head.next;
        RandomListNode newP = newHead;
        while (p.next.next != null){
            RandomListNode temp = p.next.next;
            newP.next = p.next.next.next;
            newP = newP.next;
            p.next = temp;
            p = p.next;
        }
        p.next = null;
        
        return newHead;
    }
}
