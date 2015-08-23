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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList();
        if (root == null)
            return ans;
        search(ans, new LinkedList(), root, sum);
        return ans;
    }
    
    private void search(List<List<Integer>> ans, List<Integer> now, TreeNode root, int remain){
        if (root.left == null && root.right == null){
            if (remain == root.val){
                now.add(root.val);
                List<Integer> temp = new LinkedList();
                Iterator<Integer> iterator = now.iterator();
                while (iterator.hasNext())
                    temp.add(iterator.next());
                ans.add(temp);
                now.remove(now.size()-1);
            }
            return;
        }
        
        now.add(root.val);
        if (root.left != null)
            search(ans, now, root.left, remain - root.val);
        if (root.right != null)
            search(ans, now, root.right, remain - root.val);
        now.remove(now.size()-1);
    }
}
