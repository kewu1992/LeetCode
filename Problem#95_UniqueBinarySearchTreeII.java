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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] ans = new LinkedList[n + 1];
        ans[0] = new LinkedList();
        ans[0].add(null);
        for (int i = 1; i <= n; i++){
            ans[i] = new LinkedList();
            for (int j = 1; j <= i; j++)
                for (TreeNode LNode : ans[j-1])
                    for (TreeNode RNode : ans[i-j]){
                        TreeNode temp = new TreeNode(j);
                        temp.left = LNode;
                        temp.right = clone(RNode, j);
                        ans[i].add(temp);
                    }
        }
        return ans[n];
    }
    
    private TreeNode clone(TreeNode x, int offset){
        if (x == null)
            return null;
        TreeNode temp = new TreeNode(x.val + offset);
        temp.left = clone(x.left, offset);
        temp.right = clone(x.right, offset);
        return temp;
    }
    
    
}
