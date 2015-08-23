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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return search(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    private TreeNode search(int[] preorder, int[]inorder, int preLo, int preHi, int inLo, int inHi){
        if (preLo > preHi){
            return null;
        }
        if (preLo == preHi){
            TreeNode root = new TreeNode(preorder[preLo]);
            return root;
        }
        
        TreeNode root = new TreeNode(preorder[preLo]);
        int i;
        for (i = inLo; i <= inHi; i++)
            if (inorder[i] == preorder[preLo])
                break;
        int numL = i - inLo;
        root.left = search(preorder, inorder, preLo + 1, preLo+numL, inLo, i-1);
        root.right = search(preorder, inorder, preLo+numL+1, preHi, i+1, inHi);
        
        return root;
    }
}
