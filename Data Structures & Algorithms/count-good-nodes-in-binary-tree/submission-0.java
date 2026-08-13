/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return count(root, Long.MIN_VALUE);
    }

    int count(TreeNode root, long value){
        if(root == null){
            return 0;
        }

        int res = root.val<value ? 0 : 1;
        value = Math.max(value, root.val);

        return res + count(root.left, value)
        + count(root.right, value);
    }
}
