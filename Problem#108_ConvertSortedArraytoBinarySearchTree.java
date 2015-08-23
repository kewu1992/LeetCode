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
    public TreeNode sortedArrayToBST(int[] nums) {
        return search(nums, 0, nums.length-1);
    }
    
    private TreeNode search(int[] nums, int lo, int hi){
        if (lo > hi)
            return null;
        if (lo == hi){
            return new TreeNode(nums[lo]);
        }
        int m = (lo + hi) / 2;
        TreeNode temp = new TreeNode(nums[m]);
        temp.left = search(nums, lo, m-1);
        temp.right = search(nums, m+1, hi);
        return temp;
    }
}
