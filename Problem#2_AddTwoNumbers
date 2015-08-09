/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode last = ans;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int add = l1.val + l2.val + carry;
            ListNode temp = new ListNode(add % 10);
            carry = add / 10;
            last.next = temp;
            last = temp;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null || l2 != null){
            if (l1 != null) {
                int add = l1.val + carry;
                ListNode temp = new ListNode(add % 10);
                carry = add / 10;
                last.next = temp;
                last = temp;
                l1 = l1.next;
            }   else {
                int add = l2.val + carry;
                ListNode temp = new ListNode(add % 10);
                carry = add / 10;
                last.next = temp;
                last = temp;
                l2 = l2.next;
            }
        }
        if (carry == 1){
            ListNode temp = new ListNode(1);
            last.next = temp;
        }
        return ans.next;
    }
}
