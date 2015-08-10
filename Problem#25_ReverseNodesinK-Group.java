public class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode[] temp = new ListNode[k];
            ListNode finalHead = new ListNode(0);
            finalHead.next = head;
            ListNode p = finalHead, q = p.next, tempNext;
            int n = 0;
            while (q != null){
                temp[n++] = q;
                if (n == k){
                    tempNext = temp[n-1].next;
                    for (int i = n-1; i > 0; i--)
                        temp[i].next = temp[i-1];
                    temp[0].next = tempNext;
                    p.next = temp[n-1];
                    q = temp[0];
                    p = temp[0];
                    n = 0;
                }
                q = q.next;
            }
            return finalHead.next;
        }
}
