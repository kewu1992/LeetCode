/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode now = root;
        TreeLinkNode nextHead = null;
        TreeLinkNode last = null;
        while (now != null){
            while (now != null){
                if (now.left != null){
                    if (last == null)
                        nextHead = now.left;
                     else
                        last.next = now.left;
                    last = now.left;
                }
                if (now.right != null){
                    if (last == null)
                        nextHead = now.right;
                    else
                        last.next = now.right;
                    last = now.right;
                }
                now = now.next;
            }
            now = nextHead;
            nextHead = null;
            last = null;
        }
    }
    

}
