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
    private int ans = -1;
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        search(root, 1);
        return ans;
    }
    
    private void search(TreeNode root, int depth){
        if (root.left == null && root.right == null){
            if (ans == -1 || ans > depth)
                ans = depth;
            return;
        }
        
        if (root.left != null)
            search(root.left, depth+1);
        if (root.right != null)
            search(root.right, depth+1);
    }
}
