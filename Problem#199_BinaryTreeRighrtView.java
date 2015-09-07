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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>();
        if (root == null)
            return ans;
        LinkedList<TreeNode> deque = new LinkedList<TreeNode>();
        deque.add(root);
        while (!deque.isEmpty()){
            ans.add(deque.getLast().val);
            int size = deque.size();
            for (int i = 0; i < size; i++){
                TreeNode temp = deque.removeFirst();
                if (temp.left != null)
                    deque.addLast(temp.left);
                if (temp.right != null)
                    deque.addLast(temp.right);
            }
        }
        return ans;
    }
}
