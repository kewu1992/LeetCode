
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        int num = lists.length;
        while (num > 1){
            int nextNum = (num + 1) / 2;
            ListNode[] heads = new ListNode[nextNum];
            for (int i = 0; i < num / 2; i++){
                heads[i] = mergeTwoLists(lists[i*2], lists[i*2+1]);
            }
            if (num % 2 == 1)
                heads[nextNum - 1] = lists[lists.length - 1];
            lists = heads;
            num = nextNum;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
