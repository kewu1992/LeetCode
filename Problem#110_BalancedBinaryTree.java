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
    private class Element{
        boolean isBalanced;
        int height;
        Element(boolean ans, int h){
            isBalanced = ans;
            height = h;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return search(root).isBalanced;
    }
    
    private Element search(TreeNode root){
        if (root == null)
            return new Element(true, 0);
        
        Element temp = search(root.left);
        if (!temp.isBalanced)
            return new Element(false, 0);
        Element temp2 = search(root.right);
        if (!temp2.isBalanced)
            return new Element(false, 0);
        
        if (Math.abs(temp.height - temp2.height) > 1)
            return new Element(false, 0);
        else
            return new Element(true, Integer.max(temp.height, temp2.height) + 1);
    }
}
