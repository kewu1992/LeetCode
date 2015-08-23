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
    private int ans;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        if (root != null)
            search(root, 0);
        return ans;
    }
    
    private void search(TreeNode root, int now){
        if (root.left == null && root.right == null){
            now *= 10;
            now += root.val;
            ans += now;
            return;
        }
        now *= 10;
        now += root.val;
        if (root.left != null)
            search(root.left, now);
        if (root.right != null)
            search(root.right, now);
    }
}
