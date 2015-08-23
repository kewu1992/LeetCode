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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return search(postorder, inorder, 0, postorder.length-1, 0, inorder.length-1);
    }

    private TreeNode search(int[] postorder, int[] inorder, int postLo, int postHi, int inLo, int inHi){
        if (postLo > postHi){
            return null;
        }
        if (postLo == postHi){
            TreeNode root = new TreeNode(postorder[postHi]);
            return root;
        }
        
        TreeNode root = new TreeNode(postorder[postHi]);
        int i;
        for (i = inLo; i <= inHi; i++)
            if (inorder[i] == postorder[postHi])
                break;
        int numR =  inHi - i;
        root.left = search(postorder, inorder, postLo, postHi-numR-1, inLo, i-1);
        root.right = search(postorder, inorder, postHi-numR, postHi-1, i+1, inHi);
        
        return root;
    }
}
