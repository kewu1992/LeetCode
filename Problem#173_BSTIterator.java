/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private Stack<TreeNode> stack;
    private TreeNode root;
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        this.root = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !(root == null && stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        while (root != null){
            stack.push(root);
            root = root.left;
        } 
        
        root = stack.pop();
        int temp = root.val;
        root = root.right;
        return temp;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
