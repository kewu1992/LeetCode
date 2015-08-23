/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        node = head;
        int size = 0;
        while (head != null){
            size++;
            head = head.next;
        }
        
        return inorder(0, size-1);
    }
    
    private TreeNode inorder(int lo, int hi){
        if (lo > hi)
            return null;
        if (lo == hi){
            TreeNode temp = new TreeNode(node.val);
            node = node.next;
            return temp;
        }
        
        int mid = (lo + hi) / 2;
        TreeNode temp = new TreeNode(0);
        temp.left = inorder(lo, mid-1);
        
        temp.val = node.val;
        node = node.next;
        
        temp.right = inorder(mid+1, hi);
        
        return temp;
    }
}
