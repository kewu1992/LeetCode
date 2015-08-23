/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        search(root);
    }
    
    private void search(TreeLinkNode root){
        if (root == null)
            return;
        
        search(root.left);
        search(root.right);
        
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        while (left != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }
}
