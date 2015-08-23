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
        int subAns;
        int pathSum;
        Element(int ans, int sum){
            subAns = ans;
            pathSum = sum;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        return search(root).subAns;
    }
    
    private Element search(TreeNode root){
        if (root == null){
            return new Element(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        
        Element left = search(root.left);
        Element right = search(root.right);
        
        int subAns = root.val;
        subAns += (left.pathSum > 0) ? left.pathSum : 0;
        subAns += (right.pathSum > 0) ? right.pathSum : 0;
        subAns = Integer.max(subAns, left.subAns);
        subAns = Integer.max(subAns, right.subAns);
        
        int pathSum = root.val;
        int max = Integer.max(left.pathSum, right.pathSum);
        if (max > 0)
            pathSum += max;
        
        return new Element(subAns, pathSum);
    }
}
