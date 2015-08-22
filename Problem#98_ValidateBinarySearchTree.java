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
    int lastVal;
    boolean hasFindMin;
    public boolean isValidBST(TreeNode root) {
        hasFindMin = false;
        lastVal = 0;
        return isValid(root);
    }
    
    private boolean isValid(TreeNode root){
        if (root == null)
            return true;
        
        boolean flag = isValid(root.left);
        if (!flag)
            return false;
            
        if (!hasFindMin){
            hasFindMin = true;
            lastVal = root.val;
        } else {
            if (lastVal >= root.val)
                return false;
            lastVal = root.val;
        }
        
        flag = isValid(root.right);
        if (!flag)
            return false;
        
        return true;
    }
}
