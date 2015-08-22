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
    int count;
    TreeNode[] mistakeNode;
    
    int lastVal, lastLastVal;
    int hasFindMin, hasFindMax;
    TreeNode lastNode;
    
    public void recoverTree(TreeNode root) {
        count = 0;
        mistakeNode = new TreeNode[2];
        lastVal = 0;
        lastLastVal = 0;
        hasFindMin = 0;
        hasFindMax = 0;
        
        searchFromLeft(root);
        searchFromRight(root);
        
        if (count == 2){
            int temp = mistakeNode[0].val;
            mistakeNode[0].val = mistakeNode[1].val;
            mistakeNode[1].val = temp;
        } else {
            hasFindMin = 0;
            lastNode = null;
            swapAdjacentNode(root);
        }
    }
    
    private void searchFromLeft(TreeNode root){
        if (root == null)
            return;
        searchFromLeft(root.left);
        
        if (hasFindMin == 0){
            hasFindMin++;
            lastLastVal = root.val;
        } else if (hasFindMin == 1){
            hasFindMin++;
            lastVal = root.val;
        } else {
            if (lastVal > root.val && lastLastVal > root.val){
                mistakeNode[count++] = root;    
            }
            lastLastVal = lastVal;
            lastVal = root.val;
        }
        
        searchFromLeft(root.right);
    }
    
    private void searchFromRight(TreeNode root){
        if (root == null)
            return;
        searchFromRight(root.right);
        
        if (hasFindMax == 0){
            hasFindMax++;
            lastLastVal = root.val;
        } else if (hasFindMax == 1){
            hasFindMax++;
            lastVal = root.val;
        } else {
            if (lastVal < root.val && lastLastVal < root.val){
                mistakeNode[count++] = root;    
            }
            lastLastVal = lastVal;
            lastVal = root.val;
        }
        searchFromRight(root.left);
    }
    
    private void swapAdjacentNode(TreeNode root){
        if (root == null)
            return;
        swapAdjacentNode(root.left);
        
        if (hasFindMin == 0){
            hasFindMin++;
            lastNode = root;
        } else {
            if (lastNode.val > root.val){
                int temp = lastNode.val;
                lastNode.val = root.val;
                root.val = temp;
            }
            lastNode = root;
        }
        
        swapAdjacentNode(root.right);
    }
}
