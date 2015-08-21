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
    class Element{
        TreeNode root;
        boolean hasVisited;
        Element(TreeNode r){
            root = r;
            hasVisited = false;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList();
        Stack<Element> stack = new Stack();
        if (root == null)
            return ans;
        stack.add(new Element(root));
        while (!stack.isEmpty()){
            Element temp = stack.pop();
            if (temp.hasVisited){
                ans.add(temp.root.val);
                if (temp.root.right != null)
                    stack.push(new Element(temp.root.right));
            } else {
                temp.hasVisited = true;
                stack.push(temp);
                if (temp.root.left != null)
                    stack.push(new Element(temp.root.left));
            }
        }
        return ans;
    }
    
  
}
