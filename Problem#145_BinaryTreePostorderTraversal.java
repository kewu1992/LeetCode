public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList();
        if (root == null)
            return ans;
        Stack<TreeNode> stack = new Stack();
        TreeNode pCur = null, pPre = null;
        stack.push(root);
        while (!stack.isEmpty()){
            pCur = stack.peek();
            if ((pCur.left == null && pCur.right == null) || ((pPre != null) && (pPre == pCur.left || pPre == pCur.right))){
                ans.add(pCur.val);
                pPre = stack.pop();
            } else {
                if (pCur.right != null)
                    stack.push(pCur.right);
                if (pCur.left != null)
                    stack.push(pCur.left);
            }
        }
        
        return ans;
    }
}
