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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return search(p, q);
    }
    
    private boolean search(TreeNode p, TreeNode q){
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        if (!search(p.left, q.left))
            return false;
        if (!search(p.right, q.right))
            return false;
        return true;
    }
}
