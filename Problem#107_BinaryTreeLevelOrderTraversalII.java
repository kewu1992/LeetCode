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
        int level;
        Element(TreeNode r, int l){
            root = r;
            level = l;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<Element> queue = new LinkedList();
        List<List<Integer>> ans = new LinkedList();
        List<Integer> now = new LinkedList();
        if (root == null)
            return ans;
        queue.add(new Element(root, 1));
        int nowLevel = 1;
        while (!queue.isEmpty()){
            Element temp = queue.remove();
            if (nowLevel != temp.level){
                ans.add(0, now);
                now = new LinkedList();
                nowLevel = temp.level;
            }
            now.add(temp.root.val);
            if (temp.root.left != null)
                queue.add(new Element(temp.root.left, temp.level + 1));
            if (temp.root.right != null)
                queue.add(new Element(temp.root.right, temp.level + 1));
        }
        ans.add(0, now);
        return ans;
    }
}
