/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*  divide and conquer
public class Solution {
    class Element{
        TreeNode head;
        TreeNode tail;
        Element(TreeNode root){
            head = root;
            tail = root;
            root.left = null;
            root.right = null;
        }
    }
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        search(root);
    }
    
    private Element search(TreeNode root){
        if (root.left == null && root.right == null){
            return new Element(root);
        }
        
        Element left = null, right = null;
        if (root.left != null)
            left = search(root.left);
        if (root.right != null)
            right = search(root.right);
        
        Element temp = new Element(root);
        if (left != null){
            temp.tail.right = left.head;
            temp.tail = left.tail; 
        }
        if (right != null){
            temp.tail.right = right.head;
            temp.tail = right.tail;
        }
        
        return temp;
    }
}

*/

/* using pre-order */
public class Solution{
    private TreeNode now;
    public void flatten(TreeNode root){
        now = new TreeNode(0);
        search(root);
    }
    
    private void search(TreeNode root){
        if (root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        now.right = root;
        now = root;
        now.left = null;
        now.right = null;
        
        search(left);
        search(right);
    }
}
