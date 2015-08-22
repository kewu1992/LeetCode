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
        Element(TreeNode root, int level){
            this.root = root;
            this.level = level;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList();
        if (root == null)
            return ans;
        LinkedList<Element> doubleQueue = new LinkedList();
        doubleQueue.add(new Element(root, 1));
        List<Integer> now = new LinkedList();
        int nowLevel = 1;
        int nowDirection = 0;
        while (!doubleQueue.isEmpty()){
            Element temp = null;
            if (nowDirection == 0)
                temp = doubleQueue.remove(0);
            else
                temp = doubleQueue.remove(doubleQueue.size() - 1);
            if (nowLevel != temp.level){
                ans.add(now);
                now = new LinkedList();
                nowLevel = temp.level;
                if (nowDirection == 0){
                    doubleQueue.add(0, temp);
                    temp = doubleQueue.remove(doubleQueue.size() -1 );
                } else {
                    doubleQueue.add(temp);
                    temp = doubleQueue.remove(0);
                }
                nowDirection = 1 - nowDirection;
            }
            now.add(temp.root.val);
            if (nowDirection == 0){
                if (temp.root.left != null)
                    doubleQueue.add(new Element(temp.root.left, temp.level + 1));
                if (temp.root.right != null)
                    doubleQueue.add(new Element(temp.root.right, temp.level + 1));
            } else {
                if (temp.root.right != null)
                    doubleQueue.add(0, new Element(temp.root.right, temp.level + 1));
                if (temp.root.left != null)
                    doubleQueue.add(0, new Element(temp.root.left, temp.level + 1));
            }
        }
        ans.add(now);
        return ans;
    }
}
