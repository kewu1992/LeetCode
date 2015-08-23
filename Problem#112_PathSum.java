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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return search(root, sum);
    }
    
    private boolean search(TreeNode root, int remain){
        if (root.left == null && root.right == null){
            if (remain == root.val)
                return true;
            else
                return false;
        }
        
        if (root.left != null && search(root.left, remain - root.val))
            return true;
        if (root.right != null && search(root.right, remain - root.val))
            return true;
            
        return false;
        
    }
}
